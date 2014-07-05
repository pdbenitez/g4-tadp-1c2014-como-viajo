package tadp.grupo4.comoViajo

import scala.collection.mutable.ListBuffer

class TarjetaTurismo (val zonaDescuento:String = "Centro") extends Tarjeta {
  def getDescuento(viaje :Viaje): Double =
  {
    var paradas = new ListBuffer[Parada]
    for(recorrido <-viaje.recorridos) {
      for(parada<-recorrido.trans.listaDeParadas){
        if(parada.direccion.zona.eq(zonaDescuento)) return viaje.getCosto()*0.1
      }
    }
    0
  }
}