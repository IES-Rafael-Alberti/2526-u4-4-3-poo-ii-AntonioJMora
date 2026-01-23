package org.iesra

class Tablero {
    private val tablero: Array<CharArray> = Array(3) { CharArray(3){' '} }

    fun mostrar(){
        for (i in 0..2){
            logger.info(tablero[i].joinToString(" | "))
            if (i < 2) logger.info("---|---|---")
        }
    }

    fun colocarSimbolo(fila: Int, columna: Int, simbolo: Char) : Boolean {
        if (fila in 0..2 && columna in 0..2 && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = simbolo
            return true
        }
        return false
    }

    fun hayGanador(simbolo: Char): Boolean{
        for (i in 0..2){
            if ((tablero[i][0] == simbolo && tablero[i][1]  == simbolo && tablero[i][2] == simbolo) ||
                (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo)) {
                return true
            }
        }
        if ((tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) ||
            (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo)) {
            return true
        }
        return false
    }

    fun obtenerMovimientosDisponibles(): List<Pair<Int, Int>>{
        val movimientos = mutableListOf<Pair<Int, Int>>()
        for (i in 0..2){
            for (j in 0..2){
                if (tablero[i][j] == ' ') movimientos.add(Pair(i, j))
            }
        }
        return movimientos
    }
}