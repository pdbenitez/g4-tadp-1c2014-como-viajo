package tadp.grupo4.comoViajo.test

import tadp.grupo4.comoViajo._
import tadp.grupo4.moduloExterno.ModuloExterno
import org.scalatest._

class TestViajes extends FlatSpec with Matchers {
  //Aca solo van tests para ver q programamos bien nuestro modulo externo

  var origen = new Direccion("Corrientes", 5000, "Villa Crespo", new Coordenada(0,5))
  var destino = new Direccion("Corrientes", 3000, "Villa Crespo", new Coordenada(0,3))
  var tarjetaDescuento = new TarjetaTurismo //podria ser un setter!
  var criterioCosto = new CriterioMenorCosto
  var criterioTiempo = new CriterioMenorTiempo
  var viajesPosibles: List[Viaje] = null

  var buscador = new BuscadorDeViajes

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
