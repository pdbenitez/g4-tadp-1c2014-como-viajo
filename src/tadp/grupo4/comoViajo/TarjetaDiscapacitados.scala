package tadp.grupo4.comoViajo

class TarjetaDiscapacitados extends Tarjeta{
  def getDescuento(viaje :Viaje): Double =
  {
    viaje.getCosto()
  }
}