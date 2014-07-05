package tadp.grupo4.comoViajo

class Parada(val transporte: Transporte,val direccion: Direccion) {
  def mismaDireccion(parada :Parada) = this.direccion.eq(parada.direccion)
}