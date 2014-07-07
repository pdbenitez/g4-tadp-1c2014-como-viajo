package tadp.grupo4.comoViajo

import java.util.{Comparator, Collections}

import scala.collection.JavaConverters._
import tadp.grupo4.comoViajo.CriterioBusqueda._
import tadp.grupo4.moduloExterno.ModuloExterno

import scala.collection.mutable.ListBuffer

object BuscadorDeViajes {

  var viajesHistoricos = new ListBuffer[Viaje]

  def obtenerViajes(origenNombre: String, origenAltura: Long, destinoNombre: String, destinoAltura: Long, maxDistCaminar: Double = 0.1, criterio: CriterioBusqueda = CriterioBusqueda.Tiempo): List[Viaje] = {

    val paradasOrigen = ModuloExterno.buscarParadasMasCercanas(origenNombre, origenAltura, maxDistCaminar)
    val paradasDestino = ModuloExterno.buscarParadasMasCercanas(destinoNombre, destinoAltura, maxDistCaminar)

    val viajesSinCombinacion = new ListBuffer[Viaje]

    for (paradaOrigen <- paradasOrigen; paradaDestino <- paradasDestino; if (paradaDestino.transporte.eq(paradaOrigen.transporte))) {
      val recorridos = List(new Recorrido(paradaOrigen, paradaDestino, paradaOrigen.transporte))
      viajesSinCombinacion += new Viaje(recorridos)
    }

    val viajesConCombinacion = new ListBuffer[Viaje]

    for (pOrigenInicio <- paradasOrigen; pDestinoFin <- paradasDestino; if (!pOrigenInicio.transporte.eq(pDestinoFin.transporte))) {
      for (pOrigenFin <- pOrigenInicio.transporte.listaDeParadas; paradaDestinoInicio <- pDestinoFin.transporte.listaDeParadas) {
        if (ModuloExterno.getDistanciaAPie(pOrigenFin.direccion, paradaDestinoInicio.direccion) < maxDistCaminar) {
          if ((!pOrigenInicio.eq(pOrigenFin)) && (!paradaDestinoInicio.eq(pDestinoFin))) {
            val recorridos = List(new Recorrido(pOrigenInicio, pOrigenFin, pOrigenInicio.transporte), new Recorrido(paradaDestinoInicio, pDestinoFin, pDestinoFin.transporte))
            viajesConCombinacion += new Viaje(recorridos)
          }
        }
      }
    }

    val lstViajes = viajesSinCombinacion ++ viajesConCombinacion
    criterio match {
      case CriterioBusqueda.Costo => lstViajes.sortBy(-_.getCosto()).toList //El menos me permite ordenar de menor a mayor..je
      case CriterioBusqueda.Tiempo => lstViajes.sortBy(-_.getTiempo).toList
    }
  }

  def confirmarViaje(unViaje: Viaje): Unit = {
    viajesHistoricos += unViaje
  }

  def limpiarViajes(): Unit = {
    viajesHistoricos.clear()
  }

}