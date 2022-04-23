package com.example.depalm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.depalm.databinding.ActivityVerProductoBinding
import com.google.firebase.firestore.FirebaseFirestore

class VerProducto : AppCompatActivity() {
    private lateinit var binding : ActivityVerProductoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonVolver: ImageButton = findViewById(R.id.button_volver6)

        botonVolver.setOnClickListener{
            val intent = Intent(this, MenuGestionInventario::class.java)
            startActivity(intent)
        }

        binding.productList.apply {
            layoutManager = LinearLayoutManager(this@VerProducto)
        }

        fetchData()
    }

    private fun fetchData(){
        FirebaseFirestore.getInstance().collection(globalEmail+"-productos")
            .get()
            .addOnSuccessListener { documents ->
                for(document in documents){
                    val fetchProducto = documents.toObjects(Producto::class.java)
                    binding.productList.adapter = ProductoAdapter(fetchProducto)
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