package org.iesra.ejercicio4

import org.slf4j.LoggerFactory


val logger = LoggerFactory.getLogger("Ejercicio4.9")

fun main(){
    val lista = ListaTareas()

    lista.agregarTarea("Hacer Kotlin")
    lista.agregarTarea("Hacer js")
    lista.agregarTarea("Hacer python")

    lista.cambiarEstado(2)
    lista.eliminarTarea(1)

    lista.mostrarTodas()

    lista.mostrarPendientes()

    lista.mostrarRealizadas()
}