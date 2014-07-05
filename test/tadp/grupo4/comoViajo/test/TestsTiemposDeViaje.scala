package tadp.grupo4.comoViajo.test

import org.scalatest.{Matchers, FlatSpec}
import tadp.grupo4.comoViajo.{Subte, BuscadorDeViajes}

class TestsTiemposDeViaje extends FlatSpec with Matchers {
  it should "Obtener tiempo subte SIN combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo should be(4)
  }
  it should "Obtener tiempo subte CON combinacion" in{

  }
  it should "Obtener tiempo tren SIN combinacion" in{

  }
  it should "Obtener tiempo tren CON combinacion" in{

  }
  it should "Obtener tiempo SUBTE CON combinacion en TREN" in{

  }
  it should "Obtener tiempo colectivo SIN combinacion" in{

  }
  it should "Obtener tiempo colectivo CON combinacion (Independiente de con quien)" in{

  }
}
