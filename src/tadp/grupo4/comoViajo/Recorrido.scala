package tadp.grupo4.comoViajo

class Recorrido(orig: Direccion, dest: Direccion, trans: Transporte) {

  var origen = orig
  var destino = dest
  var transporte = trans
  var costo: Double = 0
  var tiempo: Double  = 0

}