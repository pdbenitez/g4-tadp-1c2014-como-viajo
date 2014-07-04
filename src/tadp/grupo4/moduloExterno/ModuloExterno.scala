package tadp.grupo4.moduloExterno

import tadp.grupo4.comoViajo._
import scala.collection.mutable.ListBuffer

object ModuloExterno {
  var subteB: Transporte = new Subte("B")

  var paradasSubteB = List(
    new Parada(subteB, new Direccion("Corrientes", 7000, "Villa Crespo", new Coordenada(0,7))),
    new Parada(subteB, new Direccion("Corrientes", 6500, "Villa Crespo", new Coordenada(0,6.5))),
    new Parada(subteB, new Direccion("Corrientes", 6000, "Villa Crespo", new Coordenada(0,6))),
    new Parada(subteB, new Direccion("Corrientes", 5500, "Villa Crespo", new Coordenada(0,5.5))),
    new Parada(subteB, new Direccion("Corrientes", 5000, "Villa Crespo", new Coordenada(0,5))),
    new Parada(subteB, new Direccion("Corrientes", 4500, "Almagro", new Coordenada(0,4.5))),
    new Parada(subteB, new Direccion("Corrientes", 4000, "Almagro", new Coordenada(0,4))),
    new Parada(subteB, new Direccion("Corrientes", 3500, "Almagro", new Coordenada(0,3.5))),
    new Parada(subteB, new Direccion("Corrientes", 3000, "Balvanera", new Coordenada(0,3))),
    new Parada(subteB, new Direccion("Corrientes", 2500, "Balvanera", new Coordenada(0,2.5))),
    new Parada(subteB, new Direccion("Corrientes", 2000, "Balvanera", new Coordenada(0,2))),
    new Parada(subteB, new Direccion("Corrientes", 1500, "San Nicolas", new Coordenada(0,1.5))),
    new Parada(subteB, new Direccion("Corrientes", 1000, "San Nicolas", new Coordenada(0,1))),
    new Parada(subteB, new Direccion("Corrientes", 500, "Centro", new Coordenada(0,0.5))),
    new Parada(subteB, new Direccion("Corrientes", 0, "Centro", new Coordenada(0,0))))

  subteB.listaDeParadas_=(paradasSubteB)

  var colectivo24: Transporte = new Colectivo(24)
  
  var direccionesColectivo24= List(
    new Parada(colectivo24,new Direccion("Corrientes", 5000, "Villa Crespo", new Coordenada(5,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 4000, "Almagro", new Coordenada(4,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 3000, "Balvanera", new Coordenada(3,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 2000, "Balvanera", new Coordenada(2,0))),
    new Parada(colectivo24,new Direccion("Corrientes", 1000, "San Nicolas", new Coordenada(1,0))))

  colectivo24.listaDeParadas_=(direccionesColectivo24)

  var colectivo160: Transporte = new Colectivo(24)

  var direccionesColectivo160= List(
    new Parada(colectivo160,new Direccion("Rivadavia", 0,      "Centro",     new Coordenada(0,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 500,    "Centro",     new Coordenada(0.5,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 1000,   "Centro",     new Coordenada(1,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 2000,   "Centro",     new Coordenada(2,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 3000,   "Centro",     new Coordenada(3,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 4000,   "Balvanera",  new Coordenada(4,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 5000,   "Balvanera",  new Coordenada(5,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 6000,   "Balvanera",  new Coordenada(6,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 7000,   "Balvanera",  new Coordenada(7,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 8000,   "La Boca",    new Coordenada(8,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 9000,   "La Boca",    new Coordenada(9,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 10000,  "La Boca",    new Coordenada(10,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 11000,  "La Boca",    new Coordenada(11,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 12000,  "Liniers",    new Coordenada(12,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 13000,  "Liniers",    new Coordenada(13,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 14000,  "Liniers",    new Coordenada(14,4))),
    new Parada(colectivo160,new Direccion("Rivadavia", 15000,  "Liniers",    new Coordenada(15,4))))

  colectivo160.listaDeParadas_=(direccionesColectivo160)

  var todosLosTransportes: List[Transporte] = List(subteB, colectivo24, colectivo160)
  var todasLasDirecciones = List(
    //Direciones Colectivo 24 y SubteB
    new Direccion("Corrientes", 7000, "Villa Crespo", new Coordenada(0,7)),
    new Direccion("Corrientes", 6500, "Villa Crespo", new Coordenada(0,6.5)),
    new Direccion("Corrientes", 6000, "Villa Crespo", new Coordenada(0,6)),
    new Direccion("Corrientes", 5500, "Villa Crespo", new Coordenada(0,5.5)),
    new Direccion("Corrientes", 5000, "Villa Crespo", new Coordenada(0,5)),
    new Direccion("Corrientes", 4500, "Almagro", new Coordenada(0,4.5)),
    new Direccion("Corrientes", 4000, "Almagro", new Coordenada(0,4)),
    new Direccion("Corrientes", 3500, "Almagro", new Coordenada(0,3.5)),
    new Direccion("Corrientes", 3000, "Balvanera", new Coordenada(0,3)),
    new Direccion("Corrientes", 2500, "Balvanera", new Coordenada(0,2.5)),
    new Direccion("Corrientes", 2000, "Balvanera", new Coordenada(0,2)),
    new Direccion("Corrientes", 1500, "San Nicolas", new Coordenada(0,1.5)),
    new Direccion("Corrientes", 1000, "San Nicolas", new Coordenada(0,1)),
    new Direccion("Corrientes", 500, "Centro", new Coordenada(0,0.5)),
    new Direccion("Corrientes", 0, "Centro", new Coordenada(0,0)),
    //Direciones Colectivo 160
    new Direccion("Rivadavia", 0,      "Centro",     new Coordenada(0,4)),
    new Direccion("Rivadavia", 500,    "Centro",     new Coordenada(0.5,4)),
    new Direccion("Rivadavia", 1000,   "Centro",     new Coordenada(1,4)),
    new Direccion("Rivadavia", 2000,   "Centro",     new Coordenada(2,4)),
    new Direccion("Rivadavia", 3000,   "Centro",     new Coordenada(3,4)),
    new Direccion("Rivadavia", 4000,   "Balvanera",  new Coordenada(4,4)),
    new Direccion("Rivadavia", 5000,   "Balvanera",  new Coordenada(5,4)),
    new Direccion("Rivadavia", 6000,   "Balvanera",  new Coordenada(6,4)),
    new Direccion("Rivadavia", 7000,   "Balvanera",  new Coordenada(7,4)),
    new Direccion("Rivadavia", 8000,   "La Boca",    new Coordenada(8,4)),
    new Direccion("Rivadavia", 9000,   "La Boca",    new Coordenada(9,4)),
    new Direccion("Rivadavia", 10000,  "La Boca",    new Coordenada(10,4)),
    new Direccion("Rivadavia", 11000,  "La Boca",    new Coordenada(11,4)),
    new Direccion("Rivadavia", 12000,  "Liniers",    new Coordenada(12,4)),
    new Direccion("Rivadavia", 13000,  "Liniers",    new Coordenada(13,4)),
    new Direccion("Rivadavia", 14000,  "Liniers",    new Coordenada(14,4)),
    new Direccion("Rivadavia", 15000,  "Liniers",    new Coordenada(15,4))
  )

  //def puedeCombinar(unTransporte: Transporte, otroTransporte: Transporte): Unit

  def getDistanciaRecorridaPorUnColectivo(unaDireccion: Direccion, otraDireccion: Direccion): Double =
    {
      val c1 = unaDireccion.coordenada
      val c2 = otraDireccion.coordenada
      math.pow(c1.x-c2.y,2)+math.pow(c1.x-c2.y,2) //Sin raiz cuadrada asi parace q tiene q recorrer mas
    }

  def getDistanciaAPie(unaDireccion: Direccion, otraDireccion: Direccion): Double  =
    {
      val c1 = unaDireccion.coordenada
      val c2 = otraDireccion.coordenada
      math.sqrt(math.pow(c1.x-c2.x,2)+math.pow(c1.y-c2.y,2))
    }

  def getCantidadDeEstaciones(unaDireccion: Direccion, otraDireccion: Direccion): Int =
  {
    5
  }

  private def buscarDireccionMasCercana(direccionNombre: String, direccionAltura: Long): Direccion={
    var minDist=Long.MaxValue
    var dirMasCercana:Direccion=null
    for(dir <- todasLasDirecciones){
      if(dir.calle==direccionNombre && math.abs(dir.altura-direccionAltura)<minDist){
        minDist=math.abs(dir.altura-direccionAltura)
        dirMasCercana=dir
      }
    }
    dirMasCercana
  }


  def buscarParadasMasCercanas(direccionNombre: String, direccionAltura: Long, maxDist:Double = Double.MaxValue): List[(Double,Parada)] =
  {
    buscarParadasMasCercanas(buscarDireccionMasCercana(direccionNombre, direccionAltura), maxDist)
  }

  def buscarParadasMasCercanas(unaDireccion: Direccion, maxDist:Double): List[(Double,Parada)] =
  {
    var paradas = new ListBuffer[(Double,Parada)]
    for(tranporte <- todosLosTransportes){
      var parada = buscarParadaMasCercana(unaDireccion, tranporte)
      if(parada._1<maxDist) paradas+=parada
    }
    paradas.sortBy(-_._1).toList
  }

  def buscarParadaMasCercana(unaDireccion: Direccion, unTransporte: Transporte): (Double,Parada) =
    {
      var paradaMasCercana: Parada = null
      var minDist : Double = Double.MaxValue

      for(unaParada <- unTransporte.listaDeParadas){
        val dist = getDistanciaAPie(unaParada.direccion,unaDireccion)
        if(dist<minDist) {
          minDist = dist
          paradaMasCercana = unaParada
        }
      }

      (minDist,paradaMasCercana)
    }


  def dondeCombinan(transporte1 :Transporte, transporte2 :Transporte): List[Parada]={

    //Si combinan en una misma parada
    for(parada <- transporte1.listaDeParadas){
      for(parada2 <- transporte2.listaDeParadas){
        if(parada.direccion.eq(parada2.direccion)) return List(parada)
      }
    }

    //Si hay que caminar para la combinacion
    var paradasCombinacion: List[Parada] = List()
    var minDist : Double = Double.MaxValue

    for(unaParada <- transporte1.listaDeParadas){
      for(otraParada <- transporte2.listaDeParadas){
        val dist = getDistanciaAPie(unaParada.direccion,otraParada.direccion)
        if(dist<minDist) {
          minDist = dist
          paradasCombinacion = List(unaParada,otraParada)
        }
      }
    }

    paradasCombinacion
  }
}