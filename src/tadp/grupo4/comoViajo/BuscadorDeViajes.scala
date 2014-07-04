package tadp.grupo4.comoViajo

import tadp.grupo4.comoViajo.CriterioBusqueda._
import tadp.grupo4.moduloExterno.ModuloExterno

import scala.collection.mutable.ListBuffer

object BuscadorDeViajes {

  def obtenerViajes(origenNombre: String,origenAltura: Long, destinoNombre: String,destinoAltura: Long, maxDistCaminar: Double = 0.1, criterio: CriterioBusqueda = CriterioBusqueda.Tiempo): List[Viaje] ={
    val paradasOrigen = ModuloExterno.buscarParadasMasCercanas(origenNombre, origenAltura, maxDistCaminar)
    val paradasDestino = ModuloExterno.buscarParadasMasCercanas(destinoNombre, destinoAltura, maxDistCaminar)

    var viajesSinCombinacion= new ListBuffer[Viaje]

    for(paradaOrigen<-paradasOrigen){
      for(paradaDestino<-paradasDestino){
        if(paradaDestino._2.transporte.eq(paradaOrigen._2.transporte)){
          val recorridos = List(new Recorrido(paradaOrigen._2, paradaDestino._2, paradaOrigen._2.transporte))
          viajesSinCombinacion+=new Viaje(recorridos)
        }
      }
    }

    criterio match{
      case CriterioBusqueda.Costo => viajesSinCombinacion.sortBy(-_.getCosto).toList //El menos me permite ordenar de menor a mayor..je
      case CriterioBusqueda.Tiempo => viajesSinCombinacion.sortBy(-_.getTiempo).toList
    }


    //TODO: Si no hay viajes sin combinacion entonces ver los viajes posible con combinacion
    //TODO: tambien faltaria ordenar por el criterio de viaje, no se como esta pero podria ser un enum perfectamnete
    //TODO: tambien faltaria pasar la tarjeta tal y como dijo Jorge. La tarjeta puede ser un parametro opcional (Scala acepta parametros opcionales)
  }
}