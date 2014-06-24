package tadp.grupo4.comoViajo.test

import org.junit.Test

import tadp.grupo4.comoViajo.BuscadorDeViajes
import tadp.grupo4.comoViajo.CriterioMenorCosto
import tadp.grupo4.comoViajo.CriterioMenorTiempo
import tadp.grupo4.comoViajo.Direccion
import tadp.grupo4.comoViajo.TarjetaTurismo
import tadp.grupo4.comoViajo.Viaje
import tadp.grupo4.moduloExterno.ModuloExterno

class TestViajes {

  var origen = new Direccion("Corrientes", 5000, "Villa Crespo")
  var destino = new Direccion("Corrientes", 3000, "Villa Crespo")
  var tarjetaDescuento = new TarjetaTurismo //podria ser un setter!
  var criterioCosto = new CriterioMenorCosto
  var criterioTiempo = new CriterioMenorTiempo
  var viajesPosibles: List[Viaje] = Nil

  var buscador = new BuscadorDeViajes(new ModuloExterno)

  viajesPosibles = buscador.obtenerViajes(origen, destino, criterioCosto)

  @Test
  def viajeConMenorCosto = {
    var primeraOpcionViajeCosto = viajesPosibles.head
    //    viajesPosibles.foreach((unViaje: Viaje) =>
    //      assertTrue(primeraOpcionViajeCosto.getCosto < unViaje.getCosto))
  }

  viajesPosibles = buscador.obtenerViajes(origen, destino, criterioTiempo)

  @Test
  def viajeConMenorTiempo = {
    var primeraOpcionViajeTiempo = viajesPosibles.head
    //    viajesPosibles.foreach((unViaje: Viaje) =>
    //      assertTrue(primeraOpcionViajeTiempo.getTiempo < unViaje.getTiempo))
  }
}
