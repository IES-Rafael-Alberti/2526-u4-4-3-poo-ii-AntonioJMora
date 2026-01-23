package org.iesra.ejercicio1

data class Domicilio(val calle: String, val numero: Int){
    fun dirCompleta():String{
        return "$calle $numero"
    }
}
