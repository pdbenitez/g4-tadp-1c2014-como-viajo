package tadp.grupo4.comoViajo

class Tren(val ramal: String, var empresa:Empresa) extends Transporte {

  def getTiempo(unaParada: Parada, otraParada: Parada): Double =
    {
      5
    }
  def getCosto(unaParada: Parada, otraParada: Parada): Double =
    {
      this.getPrecioEnBaseAEstaciones(unaParada, otraParada)
    }

  def getPrecioEnBaseAEstaciones(origen: Parada, destino: Parada): Double =
    {
      val cantEstaciones = obtenerParadasRecorridas(origen, destino).size

      //En funcional esto va con pattern matching
      if (cantEstaciones <= 5) {
        2.0
      } else {
        if (cantEstaciones <= 8) {
          3.5
        } else
          4.75
      }
    }
}