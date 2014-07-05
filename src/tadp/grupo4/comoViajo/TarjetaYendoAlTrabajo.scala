package tadp.grupo4.comoViajo

class TarjetaYendoAlTrabajo extends Tarjeta{
  val zonasDescuento=List("Liniers","La Boca")
  def getDescuento(viaje :Viaje): Double =
  {
    val zonaOrigen = viaje.recorridos.head.orig.direccion.zona
    if(viaje.recorridos.head.dest.direccion.zona=="Centro"){
      //Aca va funcional tambien
      for(zonaDesc<-zonasDescuento){
        if(zonaOrigen==zonaDesc){
         return 1.5 //Mira como salgo del loop sin break
        }
      }
    }
    0
  }
}