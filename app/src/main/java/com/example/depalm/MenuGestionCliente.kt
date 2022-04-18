package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MenuGestionCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_gestion_cliente)
        //Variables estáticas correspondientes a los botones del menú gestión de clientes
        val botonAgregarClientes : Button = findViewById(R.id.button_agregar_cliente)
        val botonVerClientes : Button = findViewById(R.id.button_ver_clientes)
        val botonVolver: ImageButton = findViewById(R.id.button_volver)
        //Función al pulsar los botones del menú gestión de clientes
        botonAgregarClientes.setOnClickListener {
            val intent = Intent(this, AgregarCliente::class.java)
            startActivity(intent)
        }
        botonVerClientes.setOnClickListener {
            //MODIFICAR LA CLASE CUANDO ESTE LISTA LA ACTIVIDAD DE VER CLIENTES - BASE DE DATOS
            val intent = Intent(this, AgregarCliente::class.java)
            startActivity(intent)
        }
        botonVolver.setOnClickListener {
            val intent = Intent(this, MenuPrincipalAdmin::class.java)
            startActivity(intent)
        }
    }
}