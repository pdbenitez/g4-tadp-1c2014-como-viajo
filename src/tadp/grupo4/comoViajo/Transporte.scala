package tadp.grupo4.comoViajo

import scala.collection.mutable.ListBuffer

trait Transporte {

  //val moduloExterno: ModuloExterno = Nil
  var listaDeParadas: List[Parada] = Nil
  var empresa:Empresa

  def getTiempo(unaDireccion: Parada, otraDireccion: Parada): Double
  def getCosto(unaDireccion: Parada, otraDireccion: Parada): Double

  def obtenerParadasRecorridas(origen: Parada, destino: Parada):List[Parada]={
    var paradas = new ListBuffer[Parada]
    var flag = false
    for(parada<-listaDeParadas){
      if(parada.eq(origen) || parada.eq(destino)) {
        if(flag) paradas+=parada
        flag= !flag
      }
      if(flag) paradas+=parada
    }
    paradas.toList
//    val lst1 = listaDeParadas.span(x=> x.eq(origen) || x.eq(destino))
//    val cabeza = lst1._1.last
//    val resto = lst1._2
//
//    val lst2 = resto.span(x=> x.eq(origen) || x.eq(destino))
//    val cuerpo = lst2._1
//    val cola = lst2._2.head
//
//    List(cabeza):::cuerpo:::List(cola)
  }
}