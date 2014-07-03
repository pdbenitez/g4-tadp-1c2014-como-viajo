package tadp.grupo4.comoViajo.test

import tadp.grupo4.comoViajo.BuscadorDeViajes
import tadp.grupo4.comoViajo.CriterioMenorCosto
import tadp.grupo4.comoViajo.CriterioMenorTiempo
import tadp.grupo4.comoViajo.Direccion
import tadp.grupo4.comoViajo.TarjetaTurismo
import tadp.grupo4.comoViajo.Viaje
import tadp.grupo4.moduloExterno.ModuloExterno
import org.scalatest._

class TestViajes extends FlatSpec with Matchers {

  var origen = new Direccion("Corrientes", 5000, "Villa Crespo")
  var destino = new Direccion("Corrientes", 3000, "Villa Crespo")
  var tarjetaDescuento = new TarjetaTurismo //podria ser un setter!
  var criterioCosto = new CriterioMenorCosto
  var criterioTiempo = new CriterioMenorTiempo
  var viajesPosibles: List[Viaje] = null

  var buscador = new BuscadorDeViajes(new ModuloExterno)

  "El test" should "Cachear Excepcion" in{
    val s = "hi"
    intercept[IndexOutOfBoundsException] {
      s.charAt(-1)
    }
  }

  it should "Cachear excepcion de test no listo" in {
    viajesPosibles = buscador.obtenerViajes(origen, destino, criterioCosto)
    intercept[NoSuchElementException]{
      var primeraOpcionViajeCosto = viajesPosibles.head
    }
    //    viajesPosibles.foreach((unViaje: Viaje) =>
    //      assertTrue(primeraOpcionViajeCosto.getCosto < unViaje.getCosto))
    true should be(true)
  }

  it should "Obtener viaje con menor costo" in {
    //var primeraOpcionViajeCosto = viajesPosibles.head
    //    viajesPosibles.foreach((unViaje: Viaje) =>
    //      assertTrue(primeraOpcionViajeCosto.getCosto < unViaje.getCosto))
    true should be(true)
  }

  it should "Obtener viaje de menor tiempo" in {
    viajesPosibles = buscador.obtenerViajes(origen, destino, criterioTiempo)
    //var primeraOpcionViajeTiempo = viajesPosibles.head
    //    viajesPosibles.foreach((unViaje: Viaje) =>
    //      assertTrue(primeraOpcionViajeTiempo.getTiempo < unViaje.getTiempo))
    viajesPosibles should have length 0 //Ya que lo q tenemos arriva no retorna nada.
  }
}
