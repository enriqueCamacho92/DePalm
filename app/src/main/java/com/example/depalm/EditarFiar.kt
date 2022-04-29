package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class EditarFiar : AppCompatActivity() {
    private lateinit var tvNombre : TextView
    private lateinit var tvApodo : TextView
    private lateinit var tvEnvases : TextView
    private lateinit var tvFiado : TextView
    private lateinit var btnCancelar : Button
    private lateinit var btnFiar : Button
    private lateinit var btnDevolver : Button
    private lateinit var etFiar : EditText
    private val db3 = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_fiar)

        initView()
        setValuesToViews()

        btnCancelar.setOnClickListener{
            val intent = Intent(this, Fiar::class.java)
            startActivity(intent)
        }

        btnFiar.setOnClickListener {
            if(etFiar.text.isEmpty()){
                Toast.makeText(this,"Ingresa una cantidad para Fiar", Toast.LENGTH_SHORT).show()
            }
            else {
                var updatedFiar: Float = tvFiado.text.toString().toFloat()
                updatedFiar = updatedFiar + etFiar.text.toString().toFloat()

                db3.collection(globalEmail + "-clientes").document(tvNombre.text.toString()).set(
                    hashMapOf(
                        "nombre" to tvNombre.text.toString(),
                        "apodo" to tvApodo.text.toString(),
                        "envases" to tvEnvases.text.toString(),
                        "fiado" to updatedFiar.toString()
                    )
                )
                val intent = Intent(this, Fiar::class.java)
                startActivity(intent)
            }
        }

        btnDevolver.setOnClickListener {
            if(etFiar.text.isEmpty() || (etFiar.text.toString().toFloat()>tvFiado.text.toString().toFloat())){
                Toast.makeText(this,"Ingresa una cantidad para Fiar válida",Toast.LENGTH_SHORT).show()
            }
            else {
                var updatedFiar: Float = tvFiado.text.toString().toFloat()
                updatedFiar = updatedFiar - etFiar.text.toString().toFloat()

                db3.collection(globalEmail + "-clientes").document(tvNombre.text.toString()).set(
                    hashMapOf(
                        "nombre" to tvNombre.text.toString(),
                        "apodo" to tvApodo.text.toString(),
                        "envases" to tvEnvases.text.toString(),
                        "fiado" to updatedFiar.toString()
                    )
                )
                val intent = Intent(this, Fiar::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initView() {
        tvNombre = findViewById(R.id.tvNombreEditarFiar)
        tvApodo = findViewById(R.id.tvApodoEditarFiar)
        tvEnvases = findViewById(R.id.tvEnvasesEditarFiar)
        tvFiado = findViewById(R.id.tvFiadoEditarFiar)
        btnCancelar = findViewById(R.id.btnCancelarEditarFiar)
        btnDevolver = findViewById(R.id.btnDevolverEditarFiar)
        btnFiar = findViewById(R.id.btnFiarEditarFiar)
        etFiar = findViewById(R.id.etFiarEditarFiar)
    }

    private fun setValuesToViews(){
        tvNombre.text = intent.getStringExtra("nombre")
        tvApodo.text = intent.getStringExtra("apodo")
        tvEnvases.text = intent.getStringExtra("envases")
        tvFiado.text = intent.getStringExtra("fiado")
    }
}