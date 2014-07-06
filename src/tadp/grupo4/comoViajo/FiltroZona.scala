package tadp.grupo4.comoViajo

class FiltroZona (val zona: String) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.exists(x=>x.orig.direccion.zona==zona && x.dest.direccion.zona==zona)
  }

}