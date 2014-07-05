package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

class Viaje (var recorridos: List[Recorrido]){
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
      costoTotal-tarjeta.getDescuento(this)
    }

  def getTiempo: Double =
    {
      var tiempoTotal: Double = 0
      var recorridoAnterior:Recorrido = null
      for(unRecorrido<- recorridos){
        if(recorridoAnterior!=null){
          val tAnterior = recorridoAnterior.trans
          val tActual = unRecorrido.trans
          if(tAnterior.isInstanceOf[Subte] && tActual.isInstanceOf[Subte] && recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion))
            tiempoTotal+= 4
          else if (tAnterior.isInstanceOf[Subte] && tActual.isInstanceOf[Tren] && recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion))
            tiempoTotal+= 5
          else if (tAnterior.isInstanceOf[Tren] && tActual.isInstanceOf[Tren] && recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion))
            tiempoTotal+= 6
          else{
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