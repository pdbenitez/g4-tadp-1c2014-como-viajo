package tadp.grupo4.comoViajo

class Tren(val ramal: String, var empresa:Empresa, var tablaPrecios:TablaPrecios) extends Transporte {

  def getTiempo(unaParada: Parada, otraParada: Parada): Double =
    {
      5
    }
  def getCosto(origen: Parada, destino: Parada): Double =
    {
      tablaPrecios.getPrecio(obtenerParadasRecorridas(origen, destino).size-1)
    }
}