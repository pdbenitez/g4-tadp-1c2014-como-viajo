package tadp.grupo4.comoViajo.test


import org.scalatest.{Matchers, FlatSpec}
import tadp.grupo4.comoViajo._

class TestsCostos extends FlatSpec with Matchers {

    it should "Obtener costo subte SIN combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100)
    viajes.head.recorridos.head.trans shouldBe a [Subte]

    viajes.head.getCosto() should be(4.5)

  }
  it should "Obtener costo subte CON combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Esmeralda",400, "Corrientes",6300)
    viajes.head.recorridos.head.trans shouldBe a [Subte]
    viajes.head.recorridos.last.trans shouldBe a [Subte]
    viajes.head.recorridos should have size 2
    viajes.head.getCosto() should be (4.5)
  }
  it should "Obtener costo tren 3 estaciones" in{
    val viajes = BuscadorDeViajes.obtenerViajes("San Nicolas",4320, "Terrada",3550)
    viajes.head.recorridos.head.trans shouldBe a [Tren]
    viajes.head.getCosto() should be(3)
  }
  it should "Obtener costo tren 4 estaciones" in{
    val viajes = BuscadorDeViajes.obtenerViajes("San Nicolas",4320, "Elcano",4500)
    viajes.head.recorridos.head.trans shouldBe a [Tren]
    viajes.head.getCosto() should be(4.5)
  }
  it should "Obtener costo tren mas de 5 estaciones" in{
    val viajes = BuscadorDeViajes.obtenerViajes("San Nicolas",4320, "Corrientes",6600)
    viajes.head.recorridos.head.trans shouldBe a [Tren]
    viajes.head.getCosto() should be(5.75)
  }
  it should "Obtener costo tren combinacion" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Terrada", 3600, "San Lejano", 20)
    viajes.head.recorridos.head.trans shouldBe a [Tren]
    viajes.head.recorridos should have size 2

    viajes.head.getCosto() should be(6)
  }
  it should "Obtener costo colectivo 3 Km" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia",15040, "Rivadavia",14500)
    viajes.head.recorridos.head.trans shouldBe a [Colectivo]
    viajes.head.getCosto() should be(2.5)
  }
  it should "Obtener costo colectivo 6 Km" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia",15040, "Rivadavia",10040)
    viajes.head.recorridos.head.trans shouldBe a [Colectivo]
    viajes.head.getCosto() should be(2.75)
  }
  it should "Obtener costo colectivo mas de 6 Km" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia",15040, "Rivadavia",6020)
    viajes.head.recorridos.head.trans shouldBe a [Colectivo]
    viajes.head.getCosto() should be(2.85)
  }
  it should "Obtener costo con tarjeta TURISMO" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",0, "Corrientes",6100)
    viajes.head.recorridos.head.trans shouldBe a [Subte]
    viajes.head.getCosto(new TarjetaTurismo()) should be(4.5*0.9)
  }
  it should "Obtener costo con tarjeta DISCAPACITADO" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100)
    viajes.head.recorridos.head.trans shouldBe a [Subte]
    viajes.head.getCosto(new TarjetaDiscapacitados) should be(0)
  }
  it should "Obtener costo con tarjeta YENDO AL TRABAJO" in{
    val viajes = BuscadorDeViajes.obtenerViajes("Rivadavia", 9000, "Rivadavia", 1000)
    viajes.head.recorridos.head.trans shouldBe a [Colectivo]
    viajes.head.getCosto(new TarjetaYendoAlTrabajo) should be(2.85-1.5)
  }
}
