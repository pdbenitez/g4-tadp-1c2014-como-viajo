package tadp.grupo4.comoViajo

trait CriterioDeViaje {

  def ordenarViajesSegunCriterio(viajes: List[Viaje]): List[Viaje]

}