package tadp.grupo4.comoViajo.test

import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}
import tadp.grupo4.comoViajo._

/**
 * Created by martin on 03/07/14.
 */
class TestsEstadisticas extends FlatSpec with Matchers with BeforeAndAfter{
//  **DATOS A OBTENER**
//  Costo promedio de los viajes.
//  Tiempo promedio de los viajes.
//  Porcentaje de utilizacion (cantidad de viajes)
//  Facturacion total.

  before{
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100).head)
    //println(BuscadorDeViajes.obtenerViajes("Corrientes",7500, "Corrientes",6100).head.getCosto)
    BuscadorDeViajes.confirmarViaje(BuscadorDeViajes.obtenerViajes("Esmeralda",600, "Corrientes",7000).head)
    //println(BuscadorDeViajes.obtenerViajes("Esmeralda",600, "Corrientes",7000).head.getCosto)
  }

  after{
    BuscadorDeViajes.limpiarViajes()
  }

  it should "Agrego filtro tipo transporte Subte y no filtro nada" in {
    Estadistica.addFiltro(new FiltroTipoTransporte(new Subte("B")))
    println(Estadistica.costoPromedio())
  }
  it should "Agrego filtro tipo transporte que no es Subte y filtro todo" in {
    Estadistica.addFiltro(new FiltroTipoTransporte(new Tren("Mitre")))
    println(Estadistica.costoPromedio())
  }
  it should "Agrego filtro tipo Zona y no filtro nada" in {
    Estadistica.addFiltro(new FiltroZona("Villa Crespo"))
    println(Estadistica.costoPromedio())
  }
  it should "Agrego filtro tipo Zona y filtro todo" in {
    Estadistica.addFiltro(new FiltroZona("Centro"))
    println(Estadistica.costoPromedio())
  }


//  **FILTROS**
//  Comparar las diferentes zonas de la ciudad entre si.
//  Comparar las compañias de transporte entre si.
//  Comparar los tipos de transporte entre si (tren, subte, colectivo).
//  Comparar los medios de transporte entre si (cada una de las lineas)


  //Se podrian/deberian agregar mas tests (Nota: esto sale como piña en funcional con Map, FlatMap, Filter, Etc..)
  it should "El tiempo (o costo) promedio de cada tipo de transporte." in {

  }
  it should "Dada una zona la proporcion en que se reparten los viajes en esa zona entre trenes, subtes y colectivos." in {

  }
  it should "La facturacion total (en viajes seleccionados) para cada tipo de transporte para todo el sistema" in {

  }
  it should "La facturacion total de cada compañia de medios transporte." in {

  }
}
