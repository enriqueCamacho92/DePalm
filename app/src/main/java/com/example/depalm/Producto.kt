package com.example.depalm

//Modelo data class para Productos
data class Producto(var producto: String,
                    var precio: String,){
    constructor() : this(
        "",
        "",
    )
}

