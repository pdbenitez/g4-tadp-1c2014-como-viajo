package tadp.grupo4.moduloExterno

import java.util.{Comparator, Collections}
import scala.collection.JavaConverters._
import tadp.grupo4.comoViajo._
import scala.collection.mutable.ListBuffer

object ModuloExterno {
  var subteB: Transporte = new Subte("B", new Empresa("Metrovias"))

  var paradasSubteB = List(
    new Parada(subteB, new Direccion("Corrientes", 7000, "Villa Crespo",  new Coordenada(7,1))),
    new Parada(subteB, new Direccion("Corrientes", 6500, "Villa Crespo",  new Coordenada(6.5,1))),
    new Parada(subteB, new Direccion("Corrientes", 6000, "Villa Crespo",  new Coordenada(6,1))),
    new Parada(subteB, new Direccion("Corrientes", 5500, "Villa Crespo",  new Coordenada(5.5,1))),
    new Parada(subteB, new Direccion("Corrientes", 5000, "Villa Crespo",  new Coordenada(5,1))),
    new Parada(subteB, new Direccion("Corrientes", 4500, "Almagro",       new Coordenada(4.5,1))),
    new Parada(subteB, new Direccion("Corrientes", 4000, "Almagro",       new Coordenada(4,1))),
    new Parada(subteB, new Direccion("Corrientes", 3500, "Almagro",       new Coordenada(3.5,1))),
    new Parada(subteB, new Direccion("Corrientes", 3000, "Balvanera",     new Coordenada(3,1))),
    new Parada(subteB, new Direccion("Corrientes", 2500, "Balvanera",     new Coordenada(2.5,1))),
    new Parada(subteB, new Direccion("Corrientes", 2000, "Balvanera",     new Coordenada(2,1))),
    new Parada(subteB, new Direccion("Corrientes", 1500, "San Nicolas",   new Coordenada(1.5,1))),
    new Parada(subteB, new Direccion("Corrientes", 1000, "San Nicolas",   new Coordenada(1,1))),
    new Parada(subteB, new Direccion("Corrientes", 500, "Centro",         new Coordenada(0.5,1))),
    new Parada(subteB, new Direccion("Corrientes", 0, "Centro",           new Coordenada(0,1))))

  subteB.listaDeParadas_=(paradasSubteB)

  var subteC: Transporte = new Subte("C", new Empresa("Metrovias"))
  var paradasSubteC = List(
    new Parada(subteC, new Direccion("Brasil", 1100, "Constitucion", new Coordenada(1.6,5.5))),
    new Parada(subteC, new Direccion("Irigoyen", 1100, "Monserrat", new Coordenada(1.5,5))),
    new Parada(subteC, new Direccion("Irigoyen", 700, "Monserrat", new Coordenada(1.5,4))),
    new Parada(subteC, new Direccion("Irigoyen", 400, "Monserrat", new Coordenada(1.5,3))),
    new Parada(subteC, new Direccion("Irigoyen", 0, "Monserrat", new Coordenada(1.5,2))),
    new Parada(subteC, new Direccion("Corrientes", 1000, "San Nicolas", new Coordenada(1,1))),
    new Parada(subteC, new Direccion("Esmeralda", 500, "Almagro", new Coordenada(0,0))))
  subteC.listaDeParadas_=(paradasSubteC)

    def costoRoca(cantParadas: Int): Double = {
      cantParadas match{
        case x if(x<=5) => 2.0
        case x if(x<=8) => 3.5
        case x if(x>8) => 4.75
      }
    }

  var trenRoca: Transporte = new Tren("Roca", new Empresa("UGOFE"), costoRoca)
  var paradasTrenRoca = List (
    new Parada(trenRoca, new Direccion("Brasil", 1100, "Constitucion", new Coordenada(1.6,5.5))),
    new Parada(trenRoca, new Direccion("Villarino", 2300, "Barracas", new Coordenada(1.5,7.6)))
  )
  trenRoca.listaDeParadas_=(paradasTrenRoca)

    def costoUrquiza(cantParadas: Int): Double = {
      cantParadas match{
        case x if(x<=3) => 3.0
        case x if(x<=4) => 4.5
        case x if(x>4) => 5.75
      }
    }

  var trenUrquiza: Transporte = new Tren("Urquiza", new Empresa("Metrovias"), costoUrquiza)
  var paradasTrenUrquiza = List (
    new Parada(trenUrquiza, new Direccion("Corrientes", 6500, "Villa Crespo",  new Coordenada(6.5,1))),
    new Parada(trenUrquiza, new Direccion("Elcano", 4600, "Paternal",  new Coordenada(7.5,1.3))),
    new Parada(trenUrquiza, new Direccion("Chorroarin", 400, "Paternal",  new Coordenada(8.3,1.5))),
    new Parada(trenUrquiza, new Direccion("Terrada", 3600, "Agronomia",  new Coordenada(9.6,1.5))),
    new Parada(trenUrquiza, new Direccion("San Martin", 6300, "Villa Devoto",  new Coordenada(10.2,1.7))),
    new Parada(trenUrquiza, new Direccion("San Nicolas", 4300, "Villa Devoto",  new Coordenada(10.6,1.8)))
  )
  trenUrquiza.listaDeParadas_=(paradasTrenUrquiza)

  var trenUrquizaContinuacion: Transporte = new Tren("Urquiza", new Empresa("Metrovias"), costoUrquiza)
  var paradasTrenUrquizaContinuacion = List (
    new Parada(trenUrquizaContinuacion, new Direccion("San Lejano", 0, "Villa Lejano",  new Coordenada(12.6,4))),
    new Parada(trenUrquizaContinuacion, new Direccion("San Pedro", 0, "Villa Devotito",  new Coordenada(12.6,2))),
    new Parada(trenUrquizaContinuacion, new Direccion("San Nicolas", 4300, "Villa Devoto",  new Coordenada(10.6,1.8)))
  )
  trenUrquizaContinuacion.listaDeParadas_=(paradasTrenUrquizaContinuacion)

  def costoSamiento(cantParadas: Int): Double = {
    cantParadas match{
      case x if(x<=5) => 8.0
      case x if(x<=8) => 8.5
      case x if(x>8) => 9.75
    }
  }

  var trenSarmiento: Transporte = new Tren("Sarmiento", new Empresa("SOFSE"), costoSamiento)
  var paradasTrenSarmiento = List (
    new Parada(trenSarmiento, new Direccion("Pueyrredon", 100, "Balvanera", new Coordenada(3.7,4))),
    new Parada(trenSarmiento, new Direccion("Nicolas Repetto", 200, "Balvanera", new Coordenada(6.4,3.7))),
    new Parada(trenSarmiento, new Direccion("Yerbal", 2500, "Balvanera", new Coordenada(8,3.8))),
    new Parada(trenSarmiento, new Direccion("Yerbal", 3700, "La Boca", new Coordenada(9,3.9))),
    new Parada(trenSarmiento, new Direccion("Virgilio", 200, "La Boca", new Coordenada(10.7,3.9))),
    new Parada(trenSarmiento, new Direccion("Rivadavia", 11900, "La Boca", new Coordenada(12.9,4)))
  )
  trenSarmiento.listaDeParadas_=(paradasTrenSarmiento)

  var colectivo24: Transporte = new Colectivo(24, new Empresa("Empresarios Trans. Aut. de Pasajeros S.A.C.I.F."))
  var direccionesColectivo24= List(
    new Parada(colectivo24,new Direccion("Corrientes", 5000, "Villa Crespo", new Coordenada(5,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 4000, "Almagro", new Coordenada(4,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 3000, "Balvanera", new Coordenada(3,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 2000, "Balvanera", new Coordenada(2,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 1000, "San Nicolas", new Coordenada(1,0))))

  colectivo24.listaDeParadas_=(direccionesColectivo24)

  var colectivo160: Transporte = new Colectivo(160, new Empresa("Micro Omnibus Sur S.A."))

  var direccionesColectivo160= List(
    new Parada(colectivo160,new Direccion("Rivadavia", 0,      "Centro",     new Coordenada(0,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 500,    "Centro",     new Coordenada(1,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 1000,   "Centro",     new Coordenada(2,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 2000,   "Centro",     new Coordenada(3,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 3000,   "Centro",     new Coordenada(4,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 4000,   "Balvanera",  new Coordenada(5,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 5000,   "Balvanera",  new Coordenada(6,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 6000,   "Balvanera",  new Coordenada(7,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 7000,   "Balvanera",  new Coordenada(8,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 8000,   "La Boca",    new Coordenada(9,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 9000,   "La Boca",    new Coordenada(10,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 10000,  "La Boca",    new Coordenada(11,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 11000,  "La Boca",    new Coordenada(12,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 12000,  "Liniers",    new Coordenada(13,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 13000,  "Liniers",    new Coordenada(14,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 14000,  "Liniers",    new Coordenada(15,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 15000,  "Liniers",    new Coordenada(16,4))))

  colectivo160.listaDeParadas_=(direccionesColectivo160)

  var todosLosTransportes: List[Transporte] = List(subteB, subteC, colectivo24, colectivo160, trenRoca, trenSarmiento, trenUrquiza, trenUrquizaContinuacion)
  var todasLasDirecciones = List(
    //Direciones Colectivo 24 y Subte B
    new Direccion("Corrientes", 7000, "Villa Crespo",  new Coordenada(7,1)),
    new Direccion("Corrientes", 6500, "Villa Crespo",  new Coordenada(6.5,1)),
    new Direccion("Corrientes", 6000, "Villa Crespo",  new Coordenada(6,1)),
    new Direccion("Corrientes", 5500, "Villa Crespo",  new Coordenada(5.5,1)),
    new Direccion("Corrientes", 5000, "Villa Crespo",  new Coordenada(5,1)),
    new Direccion("Corrientes", 4500, "Almagro",       new Coordenada(4.5,1)),
    new Direccion("Corrientes", 4000, "Almagro",       new Coordenada(4,1)),
    new Direccion("Corrientes", 3500, "Almagro",       new Coordenada(3.5,1)),
    new Direccion("Corrientes", 3000, "Balvanera",     new Coordenada(3,1)),
    new Direccion("Corrientes", 2500, "Balvanera",     new Coordenada(2.5,1)),
    new Direccion("Corrientes", 2000, "Balvanera",     new Coordenada(2,1)),
    new Direccion("Corrientes", 1500, "San Nicolas",   new Coordenada(1.5,1)),
    new Direccion("Corrientes", 1000, "San Nicolas",   new Coordenada(1,1)),
    new Direccion("Corrientes", 500, "Centro",         new Coordenada(0.5,1)),
    new Direccion("Corrientes", 0, "Centro",           new Coordenada(0,1)),
    //Direciones Colectivo 160
    new Direccion("Rivadavia", 0,      "Centro",     new Coordenada(0,4)),
    new Direccion("Rivadavia", 500,    "Centro",     new Coordenada(1,4)),
    new Direccion("Rivadavia", 1000,   "Centro",     new Coordenada(2,4)),
    new Direccion("Rivadavia", 2000,   "Centro",     new Coordenada(3,4)),
    new Direccion("Rivadavia", 3000,   "Centro",     new Coordenada(4,4)),
    new Direccion("Rivadavia", 4000,   "Balvanera",  new Coordenada(5,4)),
    new Direccion("Rivadavia", 5000,   "Balvanera",  new Coordenada(6,4)),
    new Direccion("Rivadavia", 6000,   "Balvanera",  new Coordenada(7,4)),
    new Direccion("Rivadavia", 7000,   "Balvanera",  new Coordenada(8,4)),
    new Direccion("Rivadavia", 8000,   "La Boca",    new Coordenada(9,4)),
    new Direccion("Rivadavia", 9000,   "La Boca",    new Coordenada(10,4)),
    new Direccion("Rivadavia", 10000,  "La Boca",    new Coordenada(11,4)),
    new Direccion("Rivadavia", 11000,  "La Boca",    new Coordenada(12,4)),
    new Direccion("Rivadavia", 12000,  "Liniers",    new Coordenada(13,4)),
    new Direccion("Rivadavia", 13000,  "Liniers",    new Coordenada(14,4)),
    new Direccion("Rivadavia", 14000,  "Liniers",    new Coordenada(15,4)),
    new Direccion("Rivadavia", 15000,  "Liniers",    new Coordenada(16,4)),
    //Direciones Subte C
    new Direccion("Brasil", 1100, "Constitucion", new Coordenada(1.6,5.5)), //Compartido.. Es la cabecera del Tren Roca
    new Direccion("Irigoyen", 1000, "Centro", new Coordenada(1.5,5)),
    new Direccion("Irigoyen", 700, "Centro", new Coordenada(1.5,4)),
    new Direccion("Irigoyen", 400, "Centro", new Coordenada(1.5,3)),
    new Direccion("Irigoyen", 0, "Centro", new Coordenada(1.5,2)),
    new Direccion("Esmeralda", 500, "Almagro", new Coordenada(0,0)),
    //Direciones Tren Roca
    new Direccion("Villarino", 2300, "Barracas", new Coordenada(1.5,7.6)),
  //Direcciones Tren Urquiza
    new Direccion("Elcano", 4600, "Paternal",  new Coordenada(7.5,1.3)),
    new Direccion("Chorroarin", 400, "Paternal",  new Coordenada(8.3,1.5)),
    new Direccion("Terrada", 3600, "Agronomia",  new Coordenada(9.6,1.5)),
    new Direccion("San Martin", 6300, "Villa Devoto",  new Coordenada(10.2,1.7)),
    new Direccion("San Nicolas", 4300, "Villa Devoto",  new Coordenada(10.6,1.8)),
    //Direcciones Tres Sarmiento
    new Direccion("Pueyrredon", 100, "Balvanera", new Coordenada(3.7,4)),
    new Direccion("Nicolas Repetto", 200, "Balvanera", new Coordenada(6.4,3.7)),
    new Direccion("Yerbal", 2500, "Balvanera", new Coordenada(8,3.8)),
    new Direccion("Yerbal", 3700, "La Boca", new Coordenada(9,3.9)),
    new Direccion("Virgilio", 200, "La Boca", new Coordenada(10.7,3.9)),
    new Direccion("Rivadavia", 11900, "La Boca", new Coordenada(12.9,4)),
    //Tren Urquiza Continuacion
    new Direccion("San Lejano", 0, "Villa Lejano",  new Coordenada(12.6,4)),
    new Direccion("San Pedro", 0, "Villa Devotito",  new Coordenada(12.6,2))
  )

  def getDistanciaRecorridaPorUnColectivo(unaDireccion: Direccion, otraDireccion: Direccion): Double =
    {
      val c1 = unaDireccion.coordenada
      val c2 = otraDireccion.coordenada
      math.abs(c1.x-c2.x)+math.abs(c1.y-c2.y) //Sin raiz cuadrada asi parace q tiene q recorrer mas
    }

  def getDistanciaAPie(unaDireccion: Direccion, otraDireccion: Direccion): Double  =
    {
      val c1 = unaDireccion.coordenada
      val c2 = otraDireccion.coordenada
      math.sqrt(math.pow(c1.x-c2.x,2)+math.pow(c1.y-c2.y,2))
    }

 private def buscarDireccionMasCercana(direccionNombre: String, direccionAltura: Long): Direccion={
   todasLasDirecciones.filter(_.calle==direccionNombre).minBy(x=> math.abs( x.altura-direccionAltura))
  }


  def buscarParadasMasCercanas(direccionNombre: String, direccionAltura: Long, maxDist:Double = Double.MaxValue): List[Parada] =
  {
    buscarParadasMasCercanas(buscarDireccionMasCercana(direccionNombre, direccionAltura), maxDist)
  }

  def buscarParadasMasCercanas(unaDireccion: Direccion, maxDist:Double): List[Parada] =
  {
    todosLosTransportes.map(x=>buscarParadaMasCercana(unaDireccion, x))
                       .filter(x=>x.getDistanciaAPie(unaDireccion)<maxDist)
                       .sortBy(- _.getDistanciaAPie(unaDireccion))
  }

  def buscarParadaMasCercana(unaDireccion: Direccion, unTransporte: Transporte): Parada =
    {
      unTransporte.listaDeParadas.minBy(x=>unaDireccion.getDistanciaAPie(x.direccion))
    }


  def dondeCombinan(transporte1 :Transporte, transporte2 :Transporte): List[Parada]={

    //Si combinan en una misma parada
    for{
      parada <- transporte1.listaDeParadas
      parada2 <- transporte2.listaDeParadas
      if(parada.direccion==parada2.direccion)
    } yield return List(parada)

    //Si hay que caminar para la combinacion
    val lstParadas =for{
      unaParada <- transporte1.listaDeParadas
      otraParada <- transporte2.listaDeParadas
    } yield (unaParada, otraParada)

    val paradasCombinacion = lstParadas.minBy{case (origen,destino) => getDistanciaAPie(origen.direccion,destino.direccion)} //Unwrapping de tupla papa ;)
    List(paradasCombinacion._1,paradasCombinacion._2)
  }
}