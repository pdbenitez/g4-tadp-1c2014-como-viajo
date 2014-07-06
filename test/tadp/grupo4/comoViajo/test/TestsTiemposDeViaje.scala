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

  it should "Obtener tiempo colectivo SIN combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia", 15100,"Rivadavia",10100)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo should be(20)
  }

  it should "Obtener tiempo subte CON combinacion a tren" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Villarino",2200, "Irigoyen", 350)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo should be(14)
  }

  it should "Obtener tiempo colectivo CON combinacion a tren)" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Pueyrredon",150, "Rivadavia", 14100)
    val viajeAAnalizar= viajes.head
    viajeAAnalizar.getTiempo.round should be(25)//15min en tren + 2.49min caminando + 8min en colectivo = 25.4999993
                                                //para correr el test se redondea con .round y el resultado es 25
  }
}
