package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

trait Transporte {

  //val moduloExterno: ModuloExterno = Nil
  var listaDeParadas: List[Parada] = Nil

  def getTiempo(unaDireccion: Parada, otraDireccion: Parada): Double
  def getCosto(unaDireccion: Parada, otraDireccion: Parada): Double

}