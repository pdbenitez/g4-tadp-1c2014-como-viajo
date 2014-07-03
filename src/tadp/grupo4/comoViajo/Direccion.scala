package tadp.grupo4.comoViajo

class Direccion(val calle: String,val altura: Int,val zona: String) {
  //var calleEsquina1: String = null
  //var calleEsquina2: String = null
  def eq(unaDireccion: Direccion) = (unaDireccion.calle == calle) && (unaDireccion.altura == altura) && (unaDireccion.zona == zona)
}