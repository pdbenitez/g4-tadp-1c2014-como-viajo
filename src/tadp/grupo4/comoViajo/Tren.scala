package tadp.grupo4.comoViajo

abstract class Tren extends Transporte {

  def getTiempo(unaDireccion: Direccion, otraDireccion: Direccion): Double =
    {
      5
    }
  def getCosto(unaDireccion: Direccion, otraDireccion: Direccion): Double =
    {
      this.getPrecioEnBaseAEstaciones(unaDireccion, otraDireccion)
    }

  def getPrecioEnBaseAEstaciones(unaDireccion: Direccion, otraDireccion: Direccion): Double =
    {
      var cantEstaciones = 123 
        //this.moduloExterno.getCantidadDeEstaciones(unaDireccion, otraDireccion)
      if (cantEstaciones <= 5) {
        2.0
      } else {
        if (cantEstaciones <= 8) {
          3.5
        } else
          4.75
      }
    }
}