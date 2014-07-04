package tadp.grupo4.moduloExterno

import tadp.grupo4.comoViajo._
import scala.collection.mutable.ListBuffer

object ModuloExterno {

  var baseDeDirecciones: List[Recorrido] = Nil //ESTO ME SIRVE PARA ALGO?? ---> BORRAR

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

  var baseDeTransportesConSusParadas: List[Transporte] = List(subteB, colectivo24)

  def getTransportesQuePasanCercaDe(unaDireccion: Direccion): List[Parada] =
    {
      var paradas: ListBuffer[Parada] = new ListBuffer[Parada] 

      baseDeTransportesConSusParadas.foreach((unTransporte: Transporte) =>
        paradas+=(buscarParadaMasCercana(unaDireccion, unTransporte)))
      paradas.toList
    }
  //def puedeCombinar(unTransporte: Transporte, otroTransporte: Transporte): Unit

  def getDistanciaRecorridaPorUnColectivo(unaDireccion: Direccion, otraDireccion: Direccion): Double =
    {
      val c1 = unaDireccion.coordenada
      val c2 = otraDireccion.coordenada
      math.pow(c1.x-c2.x,2)*math.pow(c1.x-c2.x,2) //Sin raiz cuadrada asi parace q tiene q recorrer mas
    }

  def getDistanciaAPie(unaDireccion: Direccion, otraDireccion: Direccion): Double  =
    {
      val c1 = unaDireccion.coordenada
      val c2 = otraDireccion.coordenada
      math.sqrt(math.pow(c1.x-c2.x,2)*math.pow(c1.x-c2.x,2))
    }

  def getCantidadDeEstaciones(unaDireccion: Direccion, otraDireccion: Direccion): Int =
  {
    5
  }

  def buscarParadaMasCercana(unaDireccion: Direccion, unTransporte: Transporte): Parada =
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

      paradaMasCercana
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