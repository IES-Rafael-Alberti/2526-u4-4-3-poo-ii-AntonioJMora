package org.iesra

import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("Ejercicio4.7")

fun main(){
    val persona1 = Persona("123456789T")

    val cuenta1 = Cuenta(1,0.0)
    val cuenta2 = Cuenta(2,700.0)

    persona1.añadirCuenta(cuenta1)
    persona1.añadirCuenta(cuenta2)

    cuenta1.abonar(1100.0)
    cuenta2.pagar(750.0)

    logger.info("La persona es morosa?: ${Cuenta.esMorosa(persona1)}")

    Cuenta.transferencia(persona1, persona1, 1, 2, 200.0)

    logger.info("Despues de la transferencia:")
    persona1.mostrarEstado()

    logger.info("La persona es morosa?: ${Cuenta.esMorosa(persona1)}")
}
