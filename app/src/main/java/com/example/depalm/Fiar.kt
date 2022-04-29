package com.example.depalm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.depalm.databinding.ActivityFiarBinding
import com.google.firebase.firestore.FirebaseFirestore

class Fiar : AppCompatActivity() {
    private lateinit var binding : ActivityFiarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonVolver: ImageButton = findViewById(R.id.button_volver8)

        botonVolver.setOnClickListener {
            val intent = Intent(this, MenuPrincipalAdmin::class.java)
            startActivity(intent)
        }

        binding.clientList3.apply {
            layoutManager = LinearLayoutManager(this@Fiar)
        }

        fetchData()
    }

    private fun fetchData(){
        FirebaseFirestore.getInstance().collection(globalEmail+"-clientes")
            .get()
            .addOnSuccessListener { documents ->
                for(document in documents){
                    val fetchCliente = documents.toObjects(Cliente::class.java)
                    binding.clientList3.adapter = ClienteAdapter3(fetchCliente)

                    var adapter = ClienteAdapter3(fetchCliente)
                    binding.clientList3.adapter = adapter
                    adapter.setOnItemClickListener(object: ClienteAdapter3.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@Fiar, EditarFiar::class.java)
                            intent.putExtra("nombre", fetchCliente[position].nombre)
                            intent.putExtra("apodo", fetchCliente[position].apodo)
                            intent.putExtra("envases", fetchCliente[position].envases)
                            intent.putExtra("fiado",fetchCliente[position].fiado)
                            startActivity(intent)
                        }
                    })
                }

            }
            .addOnFailureListener {
                fun Context.showToast(message: String){
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
                showToast("Error: ${it.localizedMessage}")
            }
    }
}