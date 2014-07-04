package tadp.grupo4.comoViajo

class Direccion(val calle: String,val altura: Int,val zona: String, val coordenada:Coordenada) {
  def eq(unaDireccion: Direccion) = (unaDireccion.calle == calle) && (unaDireccion.altura == altura) && (unaDireccion.zona == zona)
}