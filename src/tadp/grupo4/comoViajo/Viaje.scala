package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

import scala.collection.mutable.ListBuffer

class Viaje (var recorridos: List[Recorrido]){

  def obtenerParadasRecorridas:List[Parada] = {
    recorridos.flatMap(x=>x.trans.obtenerParadasRecorridas(x.orig, x.dest))
  }

  //Recursividad FTW
  private def getInternalCost(lstRec :List[Recorrido]):Double={
    lstRec match{
      case Nil => 0
      case head::Nil => head.costo
      case head::tail if(head.trans.isInstanceOf[Subte] && tail.head.trans.isInstanceOf[Subte] && head.dest.direccion.eq(tail.head.orig.direccion)) => getInternalCost(tail)
      case head::tail => head.costo + getInternalCost(tail)
    }
  }


  def getCosto(tarjeta :Tarjeta = TarjetaSinDescuento): Double =
    {
      val total = getInternalCost(recorridos)-tarjeta.getDescuento(this)
      if(total<0) 0 else total
    }

  def getTiempo: Double =
    {
      var tiempoTotal: Double = 0
      var recorridoAnterior:Recorrido = null
      for(unRecorrido<- recorridos){
        if(recorridoAnterior!=null){//Estoy pasando de un transporte a otro
          (recorridoAnterior.trans, unRecorrido.trans) match{
            case (tAnterior:Subte, tActual:Subte) if(recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion)) => tiempoTotal+= 4//Combinacion subte
            case (tAnterior:Tren, tActual:Subte) if (recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion)) => tiempoTotal+= 5//Combinacion tren-subte
            case (tAnterior:Subte, tActual:Tren) if (recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion)) => tiempoTotal+= 5//Combinacion subte-tren
            case (tAnterior:Tren, tActual:Tren) if (recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion)) => tiempoTotal+= 6//Combinacion tren-tren
            case _ => tiempoTotal+= (ModuloExterno.getDistanciaAPie(recorridoAnterior.dest.direccion,unRecorrido.orig.direccion))*25  //((dist en km*1000/100)*2.5)
          }
        }else{
          tiempoTotal+= unRecorrido.tiempo
        }

        recorridoAnterior=unRecorrido

        if(unRecorrido!=recorridos.head)//Asi no se carga el tiempo del primer recorrido 2 veces
          tiempoTotal+= unRecorrido.tiempo
      }
      tiempoTotal
    }
}