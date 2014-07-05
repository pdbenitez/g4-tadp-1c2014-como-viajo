package tadp.grupo4.comoViajo

/**
 * Created by daniel on 05/07/14.
 */
class FiltroTipoTransporte(val transporte: Transporte) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.foreach((unRecorrido : Recorrido)=>
      if (unRecorrido.trans.getClass == transporte.getClass)
        return true)
    return false
  }

}
