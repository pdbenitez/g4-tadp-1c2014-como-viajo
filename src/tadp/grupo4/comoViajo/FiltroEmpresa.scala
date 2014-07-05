package tadp.grupo4.comoViajo

/**
 * Created by daniel on 05/07/14.
 */
class FiltroEmpresa(val empresa: Empresa) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.foreach((unRecorrido : Recorrido)=>
      if (unRecorrido.trans.empresa.empresa == empresa.empresa)
        return true)
    return false
  }

}
