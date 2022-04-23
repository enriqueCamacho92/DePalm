package com.example.depalm

//Modelo data class para Clientes
data class Cliente(var apodo: String,
                   var envases: String,
                   var fiado: String,
                   var nombre: String){
    constructor() : this(
        "",
        "",
        "",
        ""
    )
}
