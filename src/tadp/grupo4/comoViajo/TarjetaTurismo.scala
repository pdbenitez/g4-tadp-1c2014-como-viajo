package tadp.grupo4.comoViajo

import scala.collection.mutable.ListBuffer

class TarjetaTurismo (val zonaDescuento:String = "Centro") extends Tarjeta {
  def getDescuento(viaje :Viaje): Double =
  {
    val paradas = viaje.obtenerParadasRecorridas
    for(parada <-paradas) {
      if(parada.direccion.zona.eq(zonaDescuento)) return viaje.getCosto()*0.1
    }
    0
  }
}