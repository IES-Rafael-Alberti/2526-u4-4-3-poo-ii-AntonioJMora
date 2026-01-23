package org.iesra

class RepositorioCompras {
    private val compras = mutableListOf<Compra>()

    fun agregarCompra(compra: Compra){
        compras.add(compra)
    }

    fun domicilios(): MutableSet<Domicilio> {
        var domiciliosClientes = mutableSetOf<Domicilio>()
        for(compra in compras){
            domiciliosClientes.add(compra.cliente.domicilio)
        }
        return domiciliosClientes
    }
}