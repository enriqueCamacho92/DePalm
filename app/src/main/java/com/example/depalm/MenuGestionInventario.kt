package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MenuGestionInventario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_gestion_inventario)
        //Variables estáticas correspondientes a los botones del menú gestión de inventario
        val botonAgregarProductos : Button = findViewById(R.id.button_agregar_productos)
        val botonVerProductos : Button = findViewById(R.id.button_ver_productos)
        val botonVolver: ImageButton = findViewById(R.id.button_volver3)
        //Función al pulsar los botones del menú gestión de inventario
        botonAgregarProductos.setOnClickListener {
            val intent = Intent(this, AgregarProducto::class.java)
            startActivity(intent)
        }
        botonVerProductos.setOnClickListener {
            val intent = Intent(this, VerProducto::class.java)
            startActivity(intent)
        }
        botonVolver.setOnClickListener {
            val intent = Intent(this, MenuPrincipalAdmin::class.java)
            startActivity(intent)
        }
    }
}