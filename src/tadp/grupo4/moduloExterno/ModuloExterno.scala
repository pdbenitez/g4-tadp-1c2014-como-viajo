package tadp.grupo4.moduloExterno

import tadp.grupo4.comoViajo.Colectivo
import tadp.grupo4.comoViajo.Direccion
import tadp.grupo4.comoViajo.Parada
import tadp.grupo4.comoViajo.Recorrido
import tadp.grupo4.comoViajo.Subte
import tadp.grupo4.comoViajo.Transporte
import scala.collection.mutable.ListBuffer

//En funcional esto es un Object (o sea, un singleton)
class ModuloExterno {

  var baseDeDirecciones: List[Recorrido] = Nil //ESTO ME SIRVE PARA ALGO?? ---> BORRAR

  var subteB: Transporte = new Subte("B")

  var paradasSubteB = List(
    new Parada(subteB, new Direccion("Corrientes", 7000, "Villa Crespo")),
    new Parada(subteB, new Direccion("Corrientes", 6500, "Villa Crespo")),
    new Parada(subteB, new Direccion("Corrientes", 6000, "Villa Crespo")),
    new Parada(subteB, new Direccion("Corrientes", 5500, "Villa Crespo")),
    new Parada(subteB, new Direccion("Corrientes", 5000, "Villa Crespo")),
    new Parada(subteB, new Direccion("Corrientes", 4500, "Almagro")),
    new Parada(subteB, new Direccion("Corrientes", 4000, "Almagro")),
    new Parada(subteB, new Direccion("Corrientes", 3500, "Almagro")),
    new Parada(subteB, new Direccion("Corrientes", 3000, "Balvanera")),
    new Parada(subteB, new Direccion("Corrientes", 2500, "Balvanera")),
    new Parada(subteB, new Direccion("Corrientes", 2000, "Balvanera")),
    new Parada(subteB, new Direccion("Corrientes", 1500, "San Nicolas")),
    new Parada(subteB, new Direccion("Corrientes", 1000, "San Nicolas")),
    new Parada(subteB, new Direccion("Corrientes", 500, "Centro")),
    new Parada(subteB, new Direccion("Corrientes", 0, "Centro")))

  subteB.listaDeParadas_=(paradasSubteB)

  var colectivo24: Transporte = new Colectivo(24)
  
  var direccionesColectivo24= List(
    new Parada(colectivo24,new Direccion("Corrientes", 5000, "Villa Crespo")),
    new Parada(colectivo24,new Direccion("Corrientes", 4000, "Almagro")),
    new Parada(colectivo24,new Direccion("Corrientes", 3000, "Balvanera")),
    new Parada(colectivo24,new Direccion("Corrientes", 2000, "Balvanera")),
    new Parada(colectivo24,new Direccion("Corrientes", 1000, "San Nicolas")))

  
  colectivo24.listaDeParadas_=(direccionesColectivo24)

  var baseDeTransportesConSusParadas: List[Transporte] = List(subteB, colectivo24)

  baseDeDirecciones.::(
    new Recorrido(
      new Direccion("Corrientes", 6000, "Villa Crespo"),
      new Direccion("Corrientes", 2000, "Villa Crespo"),
      new Subte("B"))).::(
      new Recorrido(
        new Direccion("Corrientes", 6000, "Villa Crespo"),
        new Direccion("Corrientes", 2000, "Villa Crespo"),
        new Colectivo(24))).::(
        new Recorrido(
          new Direccion("Rivadavia 11500", 3000, "Liniers"),
          new Direccion("Corrientes", 200, "Centro"),
          new Colectivo(24)))

  def getTransportesQuePasanCercaDe(unaDireccion: Direccion): List[Parada] =
    {
      var paradas: ListBuffer[Parada] = new ListBuffer[Parada] 

      baseDeTransportesConSusParadas.foreach((unTransporte: Transporte) =>
        paradas+=(buscarParadaMasCercana(unaDireccion, unTransporte)))
      paradas.toList
    }
  //def puedeCombinar(unTransporte: Transporte, otroTransporte: Transporte): Unit

  def getDistanciaRecorridaPorUnColectivo(unaDireccion: Direccion, otraDireccion: Direccion, unCOlectivo: Colectivo): Int =
    {
      Math.abs(unaDireccion.altura - otraDireccion.altura)
    }

  def getDistanciaAPie(unaDireccion: Direccion, otraDireccion: Direccion): Int =
    {
      Math.abs(unaDireccion.altura - otraDireccion.altura)
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