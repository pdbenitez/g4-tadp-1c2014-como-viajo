package tadp.grupo4.comoViajo

class Viaje (var recorridos: List[Recorrido]){
  def getCosto(tarjeta :Tarjeta = TarjetaSinDescuento): Double =
    {
      var costoTotal: Double = 0
      var recorridoAnterior:Recorrido = null
      for(unRecorrido<- recorridos){
        if(recorridoAnterior!=null){
          val tAnterior = recorridoAnterior.trans
          val tActual = unRecorrido.trans
          if(!tAnterior.isInstanceOf[Subte] || !tActual.isInstanceOf[Subte] || !recorridoAnterior.dest.direccion.eq(unRecorrido.orig.direccion)) costoTotal+= unRecorrido.costo
        }else{
          costoTotal+= unRecorrido.costo
        }
        recorridoAnterior=unRecorrido
      }
      costoTotal-tarjeta.getDescuento(this)
    }

  def getTiempo: Double =
    {
      var tiempoTotal: Double = 0
      for(unRecorrido<- recorridos){
        tiempoTotal+= unRecorrido.tiempo
      }
      tiempoTotal
    }
}