package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

class BuscadorDeViajes (){

  var listaDeViajes: List[Viaje] = Nil
  var criterio: CriterioDeViaje =_
  var tarjeta: Tarjeta =_

  def obtenerViajes(origen: Direccion, destino: Direccion, criterio: CriterioDeViaje): List[Viaje] =
    {
    var paradasOrigen = ModuloExterno.getTransportesQuePasanCercaDe(origen)


    var paradasDestino = ModuloExterno.getTransportesQuePasanCercaDe(destino)
    //this.criterio.getViajes(moduloExterno, origen, destino, tarjeta)
    //this.moduloExterno.g
      null
    }
}