package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

import scala.collection.mutable.ListBuffer

class Viaje (var recorridos: List[Recorrido]){

  def obtenerParadasRecorridas:List[Parada] = {
    var paradas = new ListBuffer[Parada]
    for(recorrido<-recorridos) paradas++=recorrido.trans.obtenerParadasRecorridas(recorrido.orig, recorrido.dest)
    paradas.toList
  }

  def getCosto(tarjeta :Tarjeta = TarjetaSinDescuento): Double =
    {
      var costoTotal: Double = 0
      var recorridoAnterior:Recorrido = null
      for(unRecorrido<- recorridos){
        if(recorridoAnterior!=null){
          val tAnterior = recorridoAnterior.trans
          val tActual = unRecorrido.trans
          if(!tAnterior.isInstanceOf[Subte] || !tActual.isInstanceOf[Subte] || !recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion)) costoTotal+= unRecorrido.costo
        }else{
          costoTotal+= unRecorrido.costo
        }
        recorridoAnterior=unRecorrido
      }
      val total = costoTotal-tarjeta.getDescuento(this)
      if(total<0) 0 else total
    }

  def getTiempo: Double =
    {
      var tiempoTotal: Double = 0
      var recorridoAnterior:Recorrido = null
      for(unRecorrido<- recorridos){
        if(recorridoAnterior!=null){//Estoy pasando de un transporte a otro
          val tAnterior = recorridoAnterior.trans
          val tActual = unRecorrido.trans
          if(tAnterior.isInstanceOf[Subte] && tActual.isInstanceOf[Subte] && recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion))
            tiempoTotal+= 4//Combinacion subte
          else if (tAnterior.isInstanceOf[Subte] && tActual.isInstanceOf[Tren] && recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion))
            tiempoTotal+= 5//Combinacion subte-tren
          else if (tAnterior.isInstanceOf[Tren] && tActual.isInstanceOf[Tren] && recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion))
            tiempoTotal+= 6//Combinacion tren-tren
          else{//Otra combinacion
            val dirIniComb = recorridoAnterior.dest.direccion
            val dirFinComb = unRecorrido.orig.direccion
            tiempoTotal+= (ModuloExterno.getDistanciaAPie(dirIniComb,dirFinComb))*25  //((dist en km*1000/100)*2.5)
          }
        }else{
          tiempoTotal+= unRecorrido.tiempo
        }
        recorridoAnterior=unRecorrido
      }
      tiempoTotal
    }
}