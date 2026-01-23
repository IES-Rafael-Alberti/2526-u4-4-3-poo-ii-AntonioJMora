package org.iesra

import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("Ejercicio4.10")

fun main() {
    val jugador1 = Jugador("Nio", 'X')
    val jugador2 = Jugador("Yubsky", 'O')

    val juego = Juego(jugador1, jugador2)
    juego.jugar()
}