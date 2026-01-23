package org.iesra.ejercicio4


class ListaTareas {
    private val listaTareas = mutableListOf<Tarea>()
    private var siguienteId = 1

    fun agregarTarea(descripcion: String) {
        val tarea = Tarea(siguienteId, descripcion)
        listaTareas.add(tarea)
        logger.info("Tarea añadida: $tarea")
        siguienteId +=1
    }

    fun eliminarTarea(id: Int): Boolean {
        val tarea = listaTareas.find { it.id == id }
        return if (tarea != null) {
            listaTareas.remove(tarea)
            logger.info("Tarea eliminada: $tarea")
            true
        }else{
            logger.info("No se encontro la tarea con ID $id")
            false
        }
    }

    fun cambiarEstado(id: Int){
        val tarea = listaTareas.find { it.id == id }
        if (tarea != null) {
            if (tarea.realizada){
                tarea.marcarPendiente()
                logger.info("Tarea pendiente: $tarea")
            }else{
                tarea.marcarRealizada()
                logger.info("Tarea realizada: $tarea")
            }
        }else{
            logger.info("No se encontro la tarea con ID $id")
        }
    }

    fun mostrarTodas(){
        if (listaTareas.isEmpty()){
            logger.info("No hay tareas")
        }else{
            logger.info("Todas las tareas son:")
            listaTareas.forEach{logger.info(it.toString())}
        }
    }

    fun mostrarPendientes(){
        val pendientes = listaTareas.filter { !it.realizada }
        if (pendientes.isEmpty()){
            logger.info("No hay tareas pendientes")
        }else{
            logger.info("Tareas pendientes:")
            pendientes.forEach { logger.info(it.toString()) }
        }
    }

    fun mostrarRealizadas(){
        val realizadas = listaTareas.filter { it.realizada }
        if (realizadas.isEmpty()){
            logger.info("No hay tareas realizadas")
        }else{
            logger.info("Tareas realizadas:")
            realizadas.forEach { logger.info(it.toString()) }
        }
    }
}

