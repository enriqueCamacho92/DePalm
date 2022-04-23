package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MenuPrincipalAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal_admin)
        //Variables estáticas correspondientes a los botones del menú principal
        val botonGestionClientes: Button = findViewById(R.id.button_gestion_clientes)
        val botonGestionInventario: Button = findViewById(R.id.button_gestion_inventario)
        val botonVenta: Button = findViewById(R.id.button_venta)
        val botonFiar: Button = findViewById(R.id.button_fiar)
        val botonEnvases: Button = findViewById(R.id.button_envases)
        val botonSalir: Button = findViewById(R.id.button_salir)
        //Función al pulsar los botones del menú principal
        botonGestionClientes.setOnClickListener {
            val intent = Intent(this, MenuGestionCliente::class.java)
            startActivity(intent)
        }
        botonGestionInventario.setOnClickListener {
            val intent = Intent(this, MenuGestionInventario::class.java)
            startActivity(intent)
        }
        botonVenta.setOnClickListener {
            //MODIFICAR LA CLASE CUANDO ESTE LISTA LA ACTIVIDAD DE VENTAS
            val intent = Intent(this, MenuGestionInventario::class.java)
            startActivity(intent)
        }
        botonFiar.setOnClickListener {
            //MODIFICAR LA CLASE CUANDO ESTE LISTA LA ACTIVIDAD DE FIAR
            val intent = Intent(this, MenuGestionInventario::class.java)
            startActivity(intent)
        }
        botonEnvases.setOnClickListener {
            val intent = Intent(this, Envases::class.java)
            startActivity(intent)
        }
        botonSalir.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }
}