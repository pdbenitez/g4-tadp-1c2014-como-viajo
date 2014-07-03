package tadp.grupo4.comoViajo

class Colectivo(linea: Int) extends Transporte {

  val numeroColectivo = linea

  def getTiempo(unaParada: Parada, otraParada: Parada): Double =
    {
      //(this.moduloExterno.getDistanciaEntreColectivos(unaDireccion, this, this) / 1000) / 15
    15
    }
  def getCosto(unaParada: Parada, otraParada: Parada): Double =
    {
      this.getPrecioEnBaseADistancia(unaParada, otraParada)
    }

  def getPrecioEnBaseADistancia(unaParada: Parada, otraParada: Parada): Double =
    {
      var distancia = 13
      //  this.moduloExterno.getDistanciaEntreColectivos(unaDireccion, this, this) / 1000
      if (distancia < 3) {
        2.50
      } else {
        if (distancia <= 6) {
          2.75
        } else
          2.85
      }
    }
}