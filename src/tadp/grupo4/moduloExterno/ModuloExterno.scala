package tadp.grupo4.moduloExterno

import tadp.grupo4.comoViajo.Colectivo
import tadp.grupo4.comoViajo.Direccion
import tadp.grupo4.comoViajo.Parada
import tadp.grupo4.comoViajo.Recorrido
import tadp.grupo4.comoViajo.Subte
import tadp.grupo4.comoViajo.Transporte
import scala.collection.mutable.ListBuffer

class ModuloExterno {

  var baseDeDirecciones: List[Recorrido] = Nil //ESTO ME SIRVE PARA ALGO?? ---> BORRAR

  var direccionesSubteB: List[Direccion] = List(
    new Direccion("Corrientes", 7000, "Villa Crespo"),
    new Direccion("Corrientes", 6500, "Villa Crespo"),
    new Direccion("Corrientes", 6000, "Villa Crespo"),
    new Direccion("Corrientes", 5500, "Villa Crespo"),
    new Direccion("Corrientes", 5000, "Villa Crespo"),
    new Direccion("Corrientes", 4500, "Almagro"),
    new Direccion("Corrientes", 4000, "Almagro"),
    new Direccion("Corrientes", 3500, "Almagro"),
    new Direccion("Corrientes", 3000, "Balvanera"),
    new Direccion("Corrientes", 2500, "Balvanera"),
    new Direccion("Corrientes", 2000, "Balvanera"),
    new Direccion("Corrientes", 1500, "San Nicolas"),
    new Direccion("Corrientes", 1000, "San Nicolas"),
    new Direccion("Corrientes", 500, "Centro"),
    new Direccion("Corrientes", 0, "Centro"))

  var subteB: Transporte = new Subte("B")
  subteB.listaDeParadas_=(direccionesSubteB)

  var direccionesColectivo24: List[Direccion] = List(
    new Direccion("Corrientes", 5000, "Villa Crespo"),
    new Direccion("Corrientes", 4000, "Almagro"),
    new Direccion("Corrientes", 3000, "Balvanera"),
    new Direccion("Corrientes", 2000, "Balvanera"),
    new Direccion("Corrientes", 1000, "San Nicolas"))

  var colectuvo24: Transporte = new Colectivo(24)
  colectuvo24.listaDeParadas_=(direccionesColectivo24)

  var baseDeTransportesConSusParadas: List[Transporte] = List(subteB, colectuvo24)

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
      Math.abs(unaDireccion.numero - otraDireccion.numero)
    }

  def getDistanciaAPie(unaDireccion: Direccion, otraDireccion: Direccion): Int =
    {
      Math.abs(unaDireccion.numero - otraDireccion.numero)
    }

  def getCantidadDeEstaciones(unaDireccion: Direccion, otraDireccion: Direccion): Int =
    {
      5
    }

  def buscarParadaMasCercana(unaDireccion: Direccion, unTransporte: Transporte): Parada =
    {
      var paradasDeMismoTipoDeTransporte = this.baseDeTransportesConSusParadas.filter((transporte: Transporte) =>
        unTransporte.getClass() == transporte.getClass() &&
          unaDireccion.calle == transporte.listaDeParadas.head.calle)

      var alt = Int.MaxValue
      var direccionParada = unaDireccion

      paradasDeMismoTipoDeTransporte.foreach((transporte: Transporte) =>
        transporte.listaDeParadas.foreach((direccion: Direccion) =>
          if (Math.abs(unaDireccion.numero - direccion.numero) < alt) {
            alt = Math.abs(unaDireccion.numero - direccion.numero)
            direccionParada = direccion
          }))
      new Parada(unTransporte, direccionParada)
    }

}