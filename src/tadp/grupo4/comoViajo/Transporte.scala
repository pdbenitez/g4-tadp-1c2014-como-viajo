package tadp.grupo4.comoViajo

import tadp.grupo4.moduloExterno.ModuloExterno

import scala.collection.mutable.ListBuffer

trait Transporte {

  //val moduloExterno: ModuloExterno = Nil
  var listaDeParadas: List[Parada] = Nil

  def getTiempo(unaDireccion: Parada, otraDireccion: Parada): Double
  def getCosto(unaDireccion: Parada, otraDireccion: Parada): Double

  def obtenerParadasRecorridas(origen: Parada, destino: Parada):List[Parada]={
    var paradas = new ListBuffer[Parada]
    var flag = false
    for(parada<-listaDeParadas){
      if(parada.eq(origen) || parada.eq(destino)) flag= !flag;
      if(flag) paradas+=parada
    }
    paradas.toList
  }
}