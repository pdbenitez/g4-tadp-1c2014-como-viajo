package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

class BuscadorDeViajes (modulo: ModuloExterno){

  var listaDeViajes: List[Viaje] = Nil
  var moduloExterno = modulo
  var criterio: CriterioDeViaje =_
  var tarjeta: Tarjeta =_

  def obtenerViajes(origen: Direccion, destino: Direccion, criterio: CriterioDeViaje): List[Viaje] =
    {
    var paradas = this.moduloExterno.getTransportesQuePasanCercaDe(origen)
      //this.criterio.getViajes(moduloExterno, origen, destino, tarjeta)
      //this.moduloExterno.g
    
    println(paradas.toString)
      Nil
    }
  
  
}