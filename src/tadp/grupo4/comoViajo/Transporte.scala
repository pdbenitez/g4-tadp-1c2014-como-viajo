package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

trait Transporte {

  //val moduloExterno: ModuloExterno = Nil
  var listaDeParadas: List[Direccion] = Nil

  def getTiempo(unaDireccion: Direccion, otraDireccion: Direccion): Double
  def getCosto(unaDireccion: Direccion, otraDireccion: Direccion): Double

}