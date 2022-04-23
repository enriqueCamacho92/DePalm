package com.example.depalm

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
