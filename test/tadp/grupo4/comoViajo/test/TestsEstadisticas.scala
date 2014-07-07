package tadp.grupo4.comoViajo.test

import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}
import tadp.grupo4.comoViajo._
import tadp.grupo4.moduloExterno.ModuloExterno

class TestsEstadisticas extends FlatSpec with Matchers with BeforeAndAfter {
  //  **DATOS A OBTENER**
  //  Costo promedio de los viajes.
  //  Tiempo promedio de los viajes.
  //  Porcentaje de utilizacion (cantidad de viajes)
  //  Facturacion total.

    def calculadorCosto(cantParadas: Int): Double = {
      cantParadas match{
        case x if(x<=5) => 2.0
        case x if(x<=8) => 3.5
        case x if(x>8) => 4.75
      }
    }
  //4 subtes,3 subtes, 3 colec
  before {
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Corrientes", 7500, "Corrientes", 6100).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Esmeralda", 600, "Corrientes", 7000).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Brasil", 1100, "Irigoyen", 500).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Corrientes", 50, "Corrientes", 3500).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Brasil", 1100, "Villarino", 2100).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Elcano", 1100, "Terrada", 2100).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("San Lejano", 0, "San Nicolas", 4200).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Pueyrredon", 150, "Yerbal", 3650).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Rivadavia", 200, "Rivadavia", 7000).head)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Rivadavia", 14000, "Rivadavia", 50).head)
  }

  after {
    BuscadorDeViajes.limpiarViajes()
  }

  it should "Facturacion total del sistema para cada tipo de transporte" in {
    val facturacionTotal = Estadistica.facturacionTotal()
    println("Facturacion Total del sistema = " + facturacionTotal)

    Estadistica.addFiltro(new FiltroTipoTransporte(new Subte("B", new Empresa("Metrovias"))))
    val facturacionTotalSubte = Estadistica.facturacionTotal()
    println("Facturacion Total Subte = " + facturacionTotalSubte)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Colectivo(24, new Empresa("Metrovias"))))
    val facturacionTotalColectivo = Estadistica.facturacionTotal()
    println("Facturacion Total Colectivo = " + facturacionTotalColectivo)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Tren("Roca", new Empresa("UGOFE"), calculadorCosto)))
    val facturacionTotalTren = Estadistica.facturacionTotal()
    println("Facturacion Total Tren = " + facturacionTotalTren)
    Estadistica.removeFiltros()

    facturacionTotal should be(facturacionTotalSubte + facturacionTotalColectivo + facturacionTotalTren)
  }

  it should "El tiempo promedio de cada tipo de transporte." in {

    Estadistica.addFiltro(new FiltroTipoTransporte(new Subte("B", new Empresa("Metrovias"))))
    val tiempoPromedioSubte = Estadistica.tiempoPromedio()
    println("\n" + "Tiempo promedio de los viajes en Subte = " + tiempoPromedioSubte)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Colectivo(24, new Empresa("Metrovias"))))
    val tiempoPromedioColectivo = Estadistica.tiempoPromedio()
    println("Tiempo promedio de los viajes en Colectivo = " + tiempoPromedioColectivo)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Tren("Roca", new Empresa("UGOFE"), calculadorCosto)))
    val tiempoPromedioTren = Estadistica.tiempoPromedio()
    println("Tiempo promedio de los viajes en Tren = " + tiempoPromedioTren)
    Estadistica.removeFiltros()

  }
  it should "El costo promedio de cada tipo de transporte." in {

    Estadistica.addFiltro(new FiltroTipoTransporte(new Subte("B", new Empresa("Metrovias"))))
    val costoPromedioSubte = Estadistica.costoPromedio()
    println("\n" + "Costo promedio de los viajes en Subte = " + costoPromedioSubte)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Colectivo(24, new Empresa("Metrovias"))))
    val costoPromedioColectivo = Estadistica.costoPromedio()
    println("Costo promedio de los viajes en Colectivo = " + costoPromedioColectivo)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Tren("Roca", new Empresa("UGOFE"), calculadorCosto)))
    val costoPromedioTren = Estadistica.costoPromedio()
    println("Costo promedio de los viajes en Tren = " + costoPromedioTren)
    Estadistica.removeFiltros()

  }

  it should "Dada una zona la proporcion en que se reparten los viajes en esa zona entre trenes, subtes y colectivos." in {
    val cantTotalDeViajesRealizados = BuscadorDeViajes.viajesHistoricos.length
    println("\n" + "Cantidad de viajes realizados = " + cantTotalDeViajesRealizados)

    Estadistica.addFiltro(new FiltroTipoTransporte(new Subte("B", new Empresa("Metrovias"))))
    val proporcionViajesSubte = Estadistica.dameProporcion()
    println("Proporcion de viajes en subte = " + proporcionViajesSubte + "%")
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Colectivo(24, new Empresa("Metrovias"))))
    val proporcionViajesColectivo = Estadistica.dameProporcion()
    println("Proporcion de viajes en colectivo = " + proporcionViajesColectivo + "%")
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroTipoTransporte(new Tren("Roca", new Empresa("UGOFE"), calculadorCosto)))
    val proporcionViajesTren = Estadistica.dameProporcion()
    println("Proporcion de viajes en tren = " + proporcionViajesTren + "%")
    Estadistica.removeFiltros()
  }

  it should "La facturacion total de cada compañia de medios transporte." in {

    val facturacionTotal = Estadistica.facturacionTotal()
    println("\n" + "Facturacion Total = " + facturacionTotal)

    Estadistica.addFiltro(new FiltroEmpresa(new Empresa("UGOFE")))
    val facturacionempresa1 = Estadistica.facturacionTotal()
    println("Facturacion Total empresa 1 = " + facturacionempresa1)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroEmpresa(new Empresa("Metrovias")))
    val facturacionempresa2 = Estadistica.facturacionTotal()
    println("Facturacion Total empresa 2 = " + facturacionempresa2)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroEmpresa(new Empresa("Micro Omnibus Sur S.A.")))
    val facturacionempresa3 = Estadistica.facturacionTotal()
    println("Facturacion Total empresa 3 = " + facturacionempresa3)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroEmpresa(new Empresa("Empresarios Trans. Aut. de Pasajeros S.A.C.I.F.")))
    val facturacionempresa4 = Estadistica.facturacionTotal()
    println("Facturacion Total empresa 4 = " + facturacionempresa4)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroEmpresa(new Empresa("SOFSE")))
    val facturacionempresa5 = Estadistica.facturacionTotal()
    println("Facturacion Total empresa 5 = " + facturacionempresa5)
    Estadistica.removeFiltros()


  }

  it should "La facturacion total en una zona, diferenciada por transporte." in {
    Estadistica.addFiltro(new FiltroZona("Centro"))
    val facturacionTotal = Estadistica.facturacionTotal()
    println("\n" + "Facturacion Total del sistema para la zona del Centro= " + facturacionTotal)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroZona("Centro"))
    Estadistica.addFiltro(new FiltroTipoTransporte(new Subte("B", new Empresa("Metrovias"))))
    val facturacionTotalSubte = Estadistica.facturacionTotal()
    println("Facturacion Total Subte para la zona del Centro = " + facturacionTotalSubte)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroZona("Centro"))
    Estadistica.addFiltro(new FiltroTipoTransporte(new Colectivo(24, new Empresa("Metrovias"))))
    val facturacionTotalColectivo = Estadistica.facturacionTotal()
    println("Facturacion Total Colectivo para la zona del Centro = " + facturacionTotalColectivo)
    Estadistica.removeFiltros()

    Estadistica.addFiltro(new FiltroZona("Centro"))
    Estadistica.addFiltro(new FiltroTipoTransporte(new Tren("Roca", new Empresa("UGOFE"), calculadorCosto)))
    val facturacionTotalTren = Estadistica.facturacionTotal()
    println("Facturacion Total Tren para la zona del Centro = " + facturacionTotalTren)
    Estadistica.removeFiltros()

    facturacionTotal should be(facturacionTotalSubte + facturacionTotalColectivo + facturacionTotalTren)
  }
  //Se podrian agregar mas tests (Nota: esto sale como piña en funcional con Map, FlatMap, Filter, Etc..)
}
