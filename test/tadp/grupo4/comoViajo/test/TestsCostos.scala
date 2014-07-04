package tadp.grupo4.comoViajo.test

import org.scalatest.{Matchers, FlatSpec}
import tadp.grupo4.comoViajo.{Subte, BuscadorDeViajes}

/**
 * Created by martin on 03/07/14.
 */
class TestsCostos extends FlatSpec with Matchers {
  it should "Obtener costo subte SIN combinacion" in{
    var viajes = BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100)
    viajes.head.recorridos.head.trans shouldBe a [Subte]
  }
  it should "Obtener costo subte CON combinacion" in{

  }
  it should "Obtener costo tren 5 estaciones" in{

  }
  it should "Obtener costo tren 8 estaciones" in{

  }
  it should "Obtener costo tren mas de 8 estaciones" in{

  }
  it should "Obtener costo tren combinacion" in{

  }
  it should "Obtener costo colectivo 3 Km" in{

  }
  it should "Obtener costo colectivo 6 Km" in{

  }
  it should "Obtener costo colectivo mas de 6 Km" in{

  }
  it should "Obtener costo con tarjeta TURISMO" in{

  }
  it should "Obtener costo con tarjeta DISCAPACITADO" in{

  }
  it should "Obtener costo con tarjeta YENDO AL TRABAJO" in{

  }
}
