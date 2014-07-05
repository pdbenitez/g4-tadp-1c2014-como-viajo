package tadp.grupo4.comoViajo

/**
 * Created by daniel on 05/07/14.
 */
class FiltroZona (val zona: String) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.foreach((unRecorrido : Recorrido)=>
      if (unRecorrido.orig.direccion.zona == zona || unRecorrido.dest.direccion.zona == zona)
        return true)
    return false
  }

}