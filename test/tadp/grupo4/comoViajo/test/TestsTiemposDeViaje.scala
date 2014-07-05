package tadp.grupo4.comoViajo.test

import org.scalatest.{Matchers, FlatSpec}
import tadp.grupo4.comoViajo.{Subte, BuscadorDeViajes}

class TestsTiemposDeViaje extends FlatSpec with Matchers {
  it should "Obtener tiempo subte SIN combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo should be(4)
  }
  it should "Obtener tiempo subte CON combinacion a subte" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",6300, "Esmeralda", 400)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo should be(28)
  }
  it should "Obtener tiempo tren SIN combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",6300, "San Nicolas", 4200)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo should be(15)
  }
  it should "Obtener tiempo tren CON combinacion" in{

  }
  it should "Obtener tiempo SUBTE CON combinacion en TREN" in{

  }
  it should "Obtener tiempo colectivo SIN combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia", 15100,"Rivadavia",10100)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo should be(20)
  }
  it should "Obtener tiempo colectivo CON combinacion (Independiente de con quien)" in{

  }
}
