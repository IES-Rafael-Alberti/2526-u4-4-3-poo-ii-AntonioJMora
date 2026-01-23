package org.iesra

class Juego(private val jugador1: Jugador, private val jugador2: Jugador) {
    private val tablero = Tablero()


    private fun pedirMovimiento(jugador: Jugador) : Pair<Int,Int>{
        val movimientosDisponibles = tablero.obtenerMovimientosDisponibles()
        return movimientosDisponibles.random()
    }
    fun jugar(){
        val maximoMovimientos = 9
        var ganador : Jugador? = null

        for (turno in 0 until maximoMovimientos) {
            tablero.mostrar()
            val jugadorActual = if(turno % 2 == 0) jugador1 else jugador2
            logger.info("Turno de ${jugadorActual.nombre} (${jugadorActual.simbolo})")

            val movimientosDisponibles = tablero.obtenerMovimientosDisponibles()
            if (movimientosDisponibles.isNotEmpty()) {
                val (fila, columna) = pedirMovimiento(jugadorActual)
                tablero.colocarSimbolo(fila, columna, jugadorActual.simbolo)
                logger.info("${jugadorActual.nombre} coloca en ($fila, $columna)")

                if (tablero.hayGanador(jugadorActual.simbolo)){
                    ganador = jugadorActual
                }
            }
        }
        tablero.mostrar()
        if (ganador != null){
            logger.info("El ganador es: ${ganador.nombre}")
        }else{
            logger.info("No hay ganador")
        }
    }
}