package tadp.grupo4.comoViajo

class TarjetaYendoAlTrabajo {
  val zonasDescuento=List("Liniers","La Boca")
  def getDescuento(viaje :Viaje): Double =
  {
    val zonaOrigen = viaje.recorridos.head.orig.direccion.zona
    val zonaDestino = viaje.recorridos.head.orig.direccion.zona
    //Aca va funcional tambien
    for(zonaDesc<-zonasDescuento){
      if(zonaOrigen.eq(zonaDesc) && zonaDestino.eq("Centro")){
        return 1.5 //Mira como salgo del loop sin break
      }
    }
    0
  }
}