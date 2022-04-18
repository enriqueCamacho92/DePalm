package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class AgregarProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)
        //Variables estáticas correspondientes a los botones de agregar producto
        val botonAgregarProducto: Button = findViewById(R.id.button_agregar_productos2)
        val botonVolver: ImageButton = findViewById(R.id.button_volver4)
        //Función al pulsar los botones de Agregar Cliente
        botonAgregarProducto.setOnClickListener {
            //MODIFICAR CUANDO ESTE LISTA LA BASE DE DATOS
            val intent = Intent(this, AgregarCliente::class.java)
            startActivity(intent)
        }
        botonVolver.setOnClickListener{
            val intent = Intent(this, MenuGestionInventario::class.java)
            startActivity(intent)
        }
    }
}