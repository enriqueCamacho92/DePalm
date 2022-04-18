package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class AgregarCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)
        //Variables estáticas correspondientes a los botones del menú gestión de clientes
        val botonAgregarCliente: Button = findViewById(R.id.button_agregar_cliente3)
        val botonVolver: ImageButton = findViewById(R.id.button_volver2)
        //Función al pulsar los botones de Agregar Cliente
        botonAgregarCliente.setOnClickListener {
            //MODIFICAR CUANDO ESTE LISTA LA BASE DE DATOS
            val intent = Intent(this, AgregarCliente::class.java)
            startActivity(intent)
        }
        botonVolver.setOnClickListener{
            val intent = Intent(this, MenuGestionCliente::class.java)
            startActivity(intent)
        }
    }
}