package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

class Direccion(val calle: String,val altura: Int,val zona: String, val coordenada:Coordenada) {
  def eq(unaDireccion: Direccion) = (unaDireccion.calle == calle) && (unaDireccion.altura == altura) && (unaDireccion.zona == zona)
  def getDistanciaAPie(unaDireccion: Direccion) = ModuloExterno.getDistanciaAPie(this,unaDireccion)
}