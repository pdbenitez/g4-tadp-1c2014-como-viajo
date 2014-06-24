package tadp.grupo4.comoViajo

class Viaje {

  //var origen: Direccion
  //var destino: Direccion
  var recorridos: List[Recorrido] = Nil

  def getCosto: Double =
    {
      var costoTotal: Double = 0
      recorridos.foreach((unRecorrido: Recorrido) =>
        costoTotal + unRecorrido.costo)
      costoTotal
    }

  def getTiempo: Double =
    {
      var tiempoTotal: Double = 0
      recorridos.foreach((unRecorrido: Recorrido) =>
        tiempoTotal + unRecorrido.tiempo)
      tiempoTotal
    }
}