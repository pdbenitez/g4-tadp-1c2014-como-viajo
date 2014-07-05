package tadp.grupo4.comoViajo

class Viaje (var recorridos: List[Recorrido]){

  //var origen: Direccion
  //var destino: Direccion

  //TODO: No olviar usar la tarjeta para calcular el costo. Sino hacerlo afuera de aca.

  def getCosto: Double =
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
      costoTotal
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