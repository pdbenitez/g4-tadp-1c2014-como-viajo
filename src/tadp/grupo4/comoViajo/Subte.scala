package tadp.grupo4.comoViajo

class Subte(linea: String, empresa: Empresa) extends Transporte {

  val lineaSubte = linea

  def getTiempo(unaParada: Parada, otraParada: Parada): Double = 5

  def getCosto(unaParada: Parada, otraParada: Parada) = 4.5

}