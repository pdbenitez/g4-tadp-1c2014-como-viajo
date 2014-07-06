package tadp.grupo4.comoViajo

class FiltroEmpresa(val empresa: Empresa) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.foreach((unRecorrido : Recorrido)=>
      if (unRecorrido.trans.empresa.empresa == empresa.empresa)
        return true)
    return false
  }

}
