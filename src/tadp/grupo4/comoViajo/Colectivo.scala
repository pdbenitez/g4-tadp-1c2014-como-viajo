package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

class Colectivo(linea: Int, var empresa:Empresa) extends Transporte {

  val numeroColectivo = linea

  def getTiempo(unaParada: Parada, otraParada: Parada): Double =
  {
    var distRecorrida : Double=0

    val paradasIntermedias:List[Parada]=obtenerParadasRecorridas(unaParada,otraParada)
    var paradaAnterior=paradasIntermedias.head

    for(parada<-paradasIntermedias){
      distRecorrida+=ModuloExterno.getDistanciaRecorridaPorUnColectivo(paradaAnterior.direccion,parada.direccion)
      paradaAnterior=parada
    }

    // 15km    _ _ 1hs    Y     1hs _ _ 60min
    // distRec _ _ Xhs          Xhs _ _ Ymin
    distRecorrida/15*60
  }

  def getCosto(unaParada: Parada, otraParada: Parada): Double =
    {
      this.getPrecioEnBaseADistancia(unaParada, otraParada)
    }

  def getPrecioEnBaseADistancia(unaParada: Parada, otraParada: Parada): Double =
    {
      val distancia = ModuloExterno.getDistanciaRecorridaPorUnColectivo(unaParada.direccion, otraParada.direccion)
      //Aca va pattern matching de funcional
      if (distancia <= 3) {
        2.50
      } else {
        if (distancia <= 6) {
          2.75
        } else
          2.85
      }
    }
}