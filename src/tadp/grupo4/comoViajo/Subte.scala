package tadp.grupo4.comoViajo

class Subte(linea: String) extends Transporte {

  val lineaSubte = linea

  def getTiempo(unaDireccion: Direccion, otraDireccion: Direccion): Double = 5

  def getCosto(unaDireccion: Direccion, otraDireccion: Direccion) = 4.5

}