package tadp.grupo4.comoViajo

class TarjetaYendoAlTrabajo extends Tarjeta{
  val zonasDescuento=List("Liniers","La Boca")
  def getDescuento(viaje :Viaje): Double =
  {
    val zonaOrigen = viaje.recorridos.head.orig.direccion.zona
    viaje.recorridos.head.dest.direccion.zona match{
      case "Centro" => if(zonasDescuento.contains(zonaOrigen)) 1.5 else 0
      case _ => 0
    }
  }
}