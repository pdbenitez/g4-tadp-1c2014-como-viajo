package tadp.grupo4.comoViajo

class FiltroEmpresa(val empresa: Empresa) extends Filtro{

  def esCumplidoPor(unViaje : Viaje) :Boolean = {
    unViaje.recorridos.exists(x=> x.trans.empresa.eq(empresa))
  }

}
