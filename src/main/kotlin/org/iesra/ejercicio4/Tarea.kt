package org.iesra.ejercicio4

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(val id: Int, val descripcion: String) {
    var realizada: Boolean = false
    var fechaRealizada: String? = null

    fun marcarRealizada(){
        if (!realizada) {
            realizada = true
            val fechaHoraActual = LocalDateTime.now()
            val fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            fechaRealizada = fechaHoraActual.format(fechaFormateada)
        }
    }

    fun marcarPendiente(){
        realizada = false
        fechaRealizada = null
    }
    override fun toString(): String {
        return if (realizada) {
            "ID: $id | $descripcion | Realizada en: $fechaRealizada"
        } else {
            "ID: $id | $descripcion | Pendiente"
        }
    }
}