package tadp.grupo4.comoViajo.test

import org.scalatest.{Matchers, FlatSpec}
import tadp.grupo4.comoViajo.{Colectivo, Subte, BuscadorDeViajes}

/**
 * Created by martin on 03/07/14.
 */
class TestsCostos extends FlatSpec with Matchers {
  it should "Obtener costo subte SIN combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100)
    viajes.head.recorridos.head.trans shouldBe a [Subte]
    viajes.head.getCosto should be(4.5)
  }
  it should "Obtener costo subte CON combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Esmeralda",600, "Corrientes",7000)
    viajes.head.recorridos.head.trans shouldBe a [Subte]
    viajes.head.recorridos.last.trans shouldBe a [Subte]
    viajes.head.recorridos should have size 2
    viajes.head.getCosto should be (4.5)
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
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia",15040, "Rivadavia",14500)
    viajes.head.recorridos.head.trans shouldBe a [Colectivo]
    viajes.head.getCosto should be(2.5)
  }
  it should "Obtener costo colectivo 6 Km" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia",15040, "Rivadavia",10040)
    viajes.head.recorridos.head.trans shouldBe a [Colectivo]
    viajes.head.getCosto should be(2.75)
  }
  it should "Obtener costo colectivo mas de 6 Km" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia",15040, "Rivadavia",6020)
    viajes.head.recorridos.head.trans shouldBe a [Colectivo]
    viajes.head.getCosto should be(2.85)
  }
  it should "Obtener costo con tarjeta TURISMO" in{

  }
  it should "Obtener costo con tarjeta DISCAPACITADO" in{

  }
  it should "Obtener costo con tarjeta YENDO AL TRABAJO" in{

  }
}
