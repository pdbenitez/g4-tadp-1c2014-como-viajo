package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

class Parada(val transporte: Transporte,val direccion: Direccion) {
  def getDistanciaAPie(unaDireccion: Direccion) = ModuloExterno.getDistanciaAPie(direccion,unaDireccion)
}