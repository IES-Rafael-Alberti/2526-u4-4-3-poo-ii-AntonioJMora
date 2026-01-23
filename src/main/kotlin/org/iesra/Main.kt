package org.iesra

import org.slf4j.LoggerFactory
import kotlin.math.log

val logger = LoggerFactory.getLogger("Ejercicio4.6")

fun main() {
    val repositorio = RepositorioCompras()

    val cliente1 = Cliente("Antonio Mora", Domicilio("Avefría", 21))
    val cliente2 = Cliente("Arancha Salado", Domicilio("Teatro", 16))
    val cliente3 = Cliente("Karen", Domicilio("Pabellon", 12))

    repositorio.agregarCompra(Compra(cliente1, 5, 45.4))
    repositorio.agregarCompra(Compra(cliente2, 7, 6.0))
    repositorio.agregarCompra(Compra(cliente1, 7, 2.90))
    repositorio.agregarCompra(Compra(cliente3, 12, 55.99))
    repositorio.agregarCompra(Compra(cliente2, 15, 8.56))

    val domicilios = repositorio.domicilios()

    for (domicilio in domicilios){
        logger.info("Domicilio: ${domicilio.dirCompleta()}")
    }
}