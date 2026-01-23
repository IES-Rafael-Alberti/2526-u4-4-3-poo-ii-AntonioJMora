package org.iesra.ejercicio2

class Cuenta(val numeroCuenta : Int, private var saldo : Double) {
    fun consultarSaldo() : Double{
        return saldo
    }
    fun abonar(cantidad: Double){
        saldo += cantidad
    }

    fun pagar(cantidad: Double): Boolean{
        if (cantidad > saldo){
            saldo -= cantidad
            return false
        }
        saldo -= cantidad
        return true
    }

    companion object{
        fun esMorosa(persona: Persona): Boolean{
            for (cuenta in persona.cuentas){
                if (cuenta != null && cuenta.consultarSaldo()< 0){
                    return true
                }
            }
            return false
        }

        fun transferencia(origen: Persona, destino: Persona, numCuentaOrigen: Int, numCuentaDestino: Int, cantidad: Double): Boolean{
            val cuentaOrigen = origen.buscarCuenta(numCuentaOrigen)
            val cuentaDestino = destino.buscarCuenta(numCuentaDestino)

            if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.consultarSaldo() >= cantidad){
                cuentaOrigen.pagar(cantidad)
                cuentaDestino.abonar(cantidad)
                return true
            }
            return false
        }
    }
}