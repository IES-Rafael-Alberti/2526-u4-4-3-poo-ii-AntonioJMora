package org.iesra.ejercicio3

import org.iesra.ejercicio3.logger

class ConjuntoLibros(private val capacidad: Int) {
    val libros: Array<Libro?> = arrayOfNulls(capacidad)

    fun añadirLibro(libro: Libro): Boolean {
        for (l in libros) {
            if (l != null && l.titulo == libro.titulo && l.autor == libro.autor) {
                return false
            }
        }

        for (i in libros.indices) {
            if (libros[i] == null) {
                libros[i] = libro
                return true
            }
        }
        return false
    }

    fun eliminarPorTitulo(titulo: String): Boolean {
        for (i in libros.indices) {
            if (libros[i] != null && libros[i]!!.titulo == titulo) {
                libros[i] = null
                return true
            }
        }
        return false
    }

    fun eliminarPorAutor(autor : String) : Boolean {
        for (i in libros.indices) {
            if (libros[i] != null && libros[i]!!.autor == autor) {
                libros[i] = null
                return true
            }
        }
        return false
    }

    fun mostrarMayorCalificacion(){
        var mejorCalificacion : Libro? = null

        for (libro in libros) {
            if (libro != null && (mejorCalificacion == null || libro.calificacion > mejorCalificacion.calificacion)) {
                mejorCalificacion = libro
            }
        }
        if (mejorCalificacion != null) {
            logger.info("Libro con mayor calificacion = ${mejorCalificacion.titulo}")
        }else{
            logger.info("No hay libros en el conjunto")
        }
    }

    fun mostrarMenorCalificacion(){
        var peor: Libro? = null

        for (libro in libros) {
            if (libro != null && (peor == null || libro.calificacion < peor.calificacion)) {
                peor = libro
            }
        }
        if (peor != null) {
            logger.info("Libro con menor calificacion = ${peor.titulo}")
        }else{
            logger.info("No hay libros en el conjunto")
        }
    }
    fun mostrarContenido(){
        logger.info("Contenido del conjunto")
        var vacio = true
        for (libro in libros) {
            if (libro != null) {
                logger.info("$libro")
                vacio = false
            }
        }
        if (vacio) {
            logger.info("El conjunto de libros está vacío")
        }
    }

}