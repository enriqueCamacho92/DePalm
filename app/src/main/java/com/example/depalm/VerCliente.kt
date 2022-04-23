package com.example.depalm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.depalm.databinding.ActivityVerClienteBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class VerCliente : AppCompatActivity() {

    private lateinit var binding : ActivityVerClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonVolver: ImageButton = findViewById(R.id.button_volver5)
        botonVolver.setOnClickListener{
            val intent = Intent(this, MenuGestionCliente::class.java)
            startActivity(intent)
        }


        binding.clientList.apply {
            layoutManager = LinearLayoutManager(this@VerCliente)
        }

        fetchData()
    }

    private fun fetchData(){
        FirebaseFirestore.getInstance().collection(globalEmail+"-clientes")
            .get()
            .addOnSuccessListener { documents ->
                for(document in documents){
                    val fetchCliente = documents.toObjects(Cliente::class.java)
                    binding.clientList.adapter = ClienteAdapter(fetchCliente)
                }
            }
            .addOnFailureListener {
                fun Context.showToast(message: String){
                    Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
                }
                showToast("Error: ${it.localizedMessage}")
            }
    }
}