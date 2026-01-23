package org.iesra

fun main(){
    val conjunto = ConjuntoLibros(3)

    val libro1 = Libro("Invisible", "Eloy Moreno", 500,10)
    val libro2 = Libro("Redes", "Eloy Moreno2", 600,9)

    conjunto.añadirLibro(libro1)
    conjunto.añadirLibro(libro2)

    conjunto.mostrarContenido()
    conjunto.mostrarMayorCalificacion()
    conjunto.mostrarMenorCalificacion()

    conjunto.eliminarPorTitulo("Redes")
    conjunto.mostrarContenido()

    conjunto.eliminarPorAutor("Eloy Moreno")
    conjunto.mostrarContenido()

    conjunto.añadirLibro(Libro("Naruto", "Masashi Kishimoto", 1000,10))
    conjunto.mostrarContenido()

}