package tadp.grupo4.comoViajo

class FiltroTipoTransporte(val transporte: Transporte) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.foreach((unRecorrido : Recorrido)=>
      if (unRecorrido.trans.getClass == transporte.getClass)
        return true)
    return false
  }

}
