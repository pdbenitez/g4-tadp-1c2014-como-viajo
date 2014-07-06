package tadp.grupo4.comoViajo

class TarjetaTurismo (val zonaDescuento:String = "Centro") extends Tarjeta {
  def getDescuento(viaje :Viaje): Double =
  {
    if(viaje.obtenerParadasRecorridas.exists(_.direccion.zona.eq(zonaDescuento))) viaje.getCosto()*0.1 else 0
  }
}