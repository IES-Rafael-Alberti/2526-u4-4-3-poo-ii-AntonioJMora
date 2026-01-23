package org.iesra

class Persona(val dni : String) {
    val cuentas : Array<Cuenta?> = arrayOfNulls(3)

    fun añadirCuenta(cuenta: Cuenta): Boolean{
        for (i in cuentas.indices){
            if (cuentas[i] == null){
                cuentas[i] = cuenta
                return true
            }
        }
        return false
    }

    fun buscarCuenta(numeroCuenta : Int): Cuenta?{
        for (cuenta in cuentas){
            if (cuenta != null && cuenta.numeroCuenta == numeroCuenta ){
               return cuenta
            }
        }
        return null
    }

    fun mostrarEstado(){
        logger.info("Estado de la persona con DNI $dni")
        for (cuenta in cuentas){
            if (cuenta != null){
                logger.info("Cuenta ${cuenta.numeroCuenta} -> Saldo: ${cuenta.consultarSaldo()}")
            }
        }
    }
}