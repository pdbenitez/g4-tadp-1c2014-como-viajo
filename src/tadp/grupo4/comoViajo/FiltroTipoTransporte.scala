package tadp.grupo4.comoViajo

class FiltroTipoTransporte(val transporte: Transporte) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.exists(x=>x.trans.getClass==transporte.getClass)
  }

}
