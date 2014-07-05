package tadp.grupo4.comoViajo

import scala.collection.mutable.ListBuffer


object Estadistica {

  var filtros = new ListBuffer[Filtro]

  def addFiltro(unFiltro: Filtro): Unit = {
    filtros += unFiltro
  }

  def costoPromedio(): Double = {
    val viajesFiltrados = this.filtrame_viajes(BuscadorDeViajes.viajesHistoricos.toList)
    this.facturacionTotal() / viajesFiltrados.length
  }

  def tiempoPromedio(): Double = {
    val viajesFiltrados = this.filtrame_viajes(BuscadorDeViajes.viajesHistoricos.toList)
    var tiempoAcumulado: Double = 0
    viajesFiltrados.foreach((unViaje: Viaje) =>
      tiempoAcumulado += unViaje.getTiempo)
    tiempoAcumulado / viajesFiltrados.length
  }

  def facturacionTotal(): Double = {
    val viajesFiltrados = this.filtrame_viajes(BuscadorDeViajes.viajesHistoricos.toList)
    var costoAcumulado: Double = 0
    viajesFiltrados.foreach((unViaje: Viaje) =>
      costoAcumulado += unViaje.getCosto())
    costoAcumulado
  }

  def filtrame_viajes(viajes: List[Viaje]): List[Viaje] = {
    viajes.filter(unViaje =>
      filtros.forall(unFiltro => unFiltro.esCumplidoPor(unViaje)))
  }

  def removeFiltros() : Unit = {
    filtros.clear()
  }

  def dameProporcion():Double = {
    val viajesFiltrados = this.filtrame_viajes(BuscadorDeViajes.viajesHistoricos.toList)
    viajesFiltrados.length * 100 / BuscadorDeViajes.viajesHistoricos.length
  }

}
