package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AgregarCliente : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)
        //Variables estáticas correspondientes a los botones del menú gestión de clientes
        val botonAgregarCliente: Button = findViewById(R.id.button_agregar_cliente3)
        val botonVolver: ImageButton = findViewById(R.id.button_volver2)
        //Función al pulsar los botones de Agregar Cliente
        botonAgregarCliente.setOnClickListener {
            val clienteNombre: TextView = findViewById(R.id.tvCliente)
            val clienteApodo: TextView = findViewById(R.id.tvApodo)

            db.collection(globalEmail+"-clientes").document(clienteNombre.text.toString()).set(
                hashMapOf(
                    "nombre" to clienteNombre.text.toString(),
                    "apodo" to clienteApodo.text.toString(),
                    "fiado" to "00.00",
                    "envases" to "0"
                )
            )
            clienteNombre.text = ""
            clienteApodo.text = ""
        }
        botonVolver.setOnClickListener{
            val intent = Intent(this, MenuGestionCliente::class.java)
            startActivity(intent)
        }
    }
}