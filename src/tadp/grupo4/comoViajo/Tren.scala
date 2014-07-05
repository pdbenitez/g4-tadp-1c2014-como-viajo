package tadp.grupo4.comoViajo

class Tren(val ramal: String, var empresa:Empresa, var tablaPrecios:TablaPrecios) extends Transporte {

  def getTiempo(unaParada: Parada, otraParada: Parada): Double =
    {
      val paradasIntermedias:List[Parada]=obtenerParadasRecorridas(unaParada,otraParada)
      (paradasIntermedias.size-1)*3 //3 minutos por estacion de tren
    }
  def getCosto(origen: Parada, destino: Parada): Double =
    {
      tablaPrecios.getPrecio(obtenerParadasRecorridas(origen, destino).size-1)
    }
}