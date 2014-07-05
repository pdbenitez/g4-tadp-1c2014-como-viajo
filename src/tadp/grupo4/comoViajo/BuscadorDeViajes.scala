package tadp.grupo4.comoViajo

import java.util.{Comparator, Collections}

import scala.collection.JavaConverters._
import tadp.grupo4.comoViajo.CriterioBusqueda._
import tadp.grupo4.moduloExterno.ModuloExterno

import scala.collection.mutable.ListBuffer

object BuscadorDeViajes {

  var viajesHistoricos = new ListBuffer[Viaje]
  def obtenerViajes(origenNombre: String,origenAltura: Long, destinoNombre: String,destinoAltura: Long, maxDistCaminar: Double = 0.5, criterio: CriterioBusqueda = CriterioBusqueda.Tiempo): List[Viaje] ={


    val paradasOrigen = ModuloExterno.buscarParadasMasCercanas(origenNombre, origenAltura, maxDistCaminar)
    val paradasDestino = ModuloExterno.buscarParadasMasCercanas(destinoNombre, destinoAltura, maxDistCaminar)

    val viajesSinCombinacion= new ListBuffer[Viaje]

    for(paradaOrigen<-paradasOrigen){
      for(paradaDestino<-paradasDestino){
        if(paradaDestino._2.transporte.eq(paradaOrigen._2.transporte)){
          val recorridos = List(new Recorrido(paradaOrigen._2, paradaDestino._2, paradaOrigen._2.transporte))
          viajesSinCombinacion+=new Viaje(recorridos)
        }
      }
    }

    val viajesConCombinacion= new ListBuffer[Viaje]

    for(pOrigen<-paradasOrigen){
      for(pDestino<-paradasDestino) {
        for(pOrigenIntermedia<-pOrigen._2.transporte.listaDeParadas){
          for(paradaDestinoIntermedia<-pDestino._2.transporte.listaDeParadas){
            if(ModuloExterno.getDistanciaAPie(pOrigenIntermedia.direccion, paradaDestinoIntermedia.direccion)<maxDistCaminar){
              val recorridos = List(new Recorrido(pOrigen._2, pOrigenIntermedia, pOrigen._2.transporte), new Recorrido(paradaDestinoIntermedia, pDestino._2, pOrigen._2.transporte))
              viajesSinCombinacion+=new Viaje(recorridos)
            }
          }
        }
      }
    }

    var lstViajes = (viajesSinCombinacion++viajesConCombinacion).asJava
    criterio match{
      case CriterioBusqueda.Costo => Collections.sort(lstViajes, new Comparator[Viaje](){
        def compare(v1 :Viaje, v2 :Viaje):Int={
          return v1.getCosto().compareTo(v2.getCosto())
        }
      })
      case CriterioBusqueda.Tiempo => Collections.sort(lstViajes, new Comparator[Viaje](){
        def compare(v1 :Viaje, v2 :Viaje):Int={
          return v1.getTiempo.compareTo(v2.getTiempo)
        }
      })
        //Asi quedaria con funcional
//      case CriterioBusqueda.Costo => viajesSinCombinacion.sortBy(-_.getCosto).toList //El menos me permite ordenar de menor a mayor..je
//      case CriterioBusqueda.Tiempo => viajesSinCombinacion.sortBy(-_.getTiempo).toList
    }

    lstViajes.asScala.toList
  }

  def confirmarViaje(unViaje : Viaje) : Unit = {
    viajesHistoricos+=unViaje
  }
  def limpiarViajes() : Unit = {
    viajesHistoricos.clear()
  }

}