package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class AgregarProducto : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)
        //Variables estáticas correspondientes a los botones de agregar producto
        val botonAgregarProducto: Button = findViewById(R.id.button_agregar_productos2)
        val botonVolver: ImageButton = findViewById(R.id.button_volver4)
        //Función al pulsar los botones de Agregar Cliente
        botonAgregarProducto.setOnClickListener {
            val productoNombre: TextView = findViewById(R.id.tvProducto)
            val productoPrecio: TextView = findViewById(R.id.editTextNumberDecimal)
            db.collection(globalEmail+"-productos").document(productoNombre.text.toString()).set(
                hashMapOf(
                    "producto" to productoNombre.text.toString(),
                    "precio" to productoPrecio.text.toString()
                )
            )
            productoNombre.text = ""
            productoPrecio.text = ""
        }
        botonVolver.setOnClickListener{
            val intent = Intent(this, MenuGestionInventario::class.java)
            startActivity(intent)
        }
    }
}