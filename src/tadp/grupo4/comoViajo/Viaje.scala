package tadp.grupo4.comoViajo

class Viaje (var recorridos: List[Recorrido]){

  //var origen: Direccion
  //var destino: Direccion

  def getCosto: Double =
    {
      var costoTotal: Double = 0
      for(unRecorrido<- recorridos){
        costoTotal + unRecorrido.costo
      }
      costoTotal
    }

  def getTiempo: Double =
    {
      var tiempoTotal: Double = 0
      for(unRecorrido<- recorridos){
        tiempoTotal + unRecorrido.tiempo
      }
      tiempoTotal
    }
}