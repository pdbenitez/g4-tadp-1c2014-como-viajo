package tadp.grupo4.comoViajo

class Recorrido(val orig: Parada,val dest: Parada,val trans: Transporte) {
  def costo = trans.getCosto(orig,dest)
  def tiempo = trans.getTiempo(orig,dest)
}