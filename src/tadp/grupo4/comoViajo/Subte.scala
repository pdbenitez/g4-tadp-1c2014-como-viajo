package tadp.grupo4.comoViajo

class Subte(linea: String, var empresa: Empresa) extends Transporte {

  val lineaSubte = linea

  def getTiempo(unaParada: Parada, otraParada: Parada): Double =
  {
    val paradasIntermedias=obtenerParadasRecorridas(unaParada,otraParada)
    (paradasIntermedias.size-1)*2 //2 minutos por estacion de subte
  }

  def getCosto(unaParada: Parada, otraParada: Parada) = 4.5

}