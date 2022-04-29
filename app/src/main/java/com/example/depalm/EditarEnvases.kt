package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class EditarEnvases : AppCompatActivity() {
    private lateinit var tvNombre : TextView
    private lateinit var tvApodo : TextView
    private lateinit var tvEnvases : TextView
    private lateinit var tvFiado : TextView
    private lateinit var btnCancelar : Button
    private lateinit var btnPrestar : Button
    private lateinit var btnDevolver : Button
    private lateinit var etEnvases : EditText
    private val db2 = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_envases)

        initView()
        setValuesToViews()

        btnCancelar.setOnClickListener{
            val intent = Intent(this, Envases::class.java)
            startActivity(intent)
        }

        btnPrestar.setOnClickListener {
            if(etEnvases.text.isEmpty()){
               Toast.makeText(this,"Ingresa una cantidad de Envases",Toast.LENGTH_SHORT).show()
            }
            else {
                var updatedEnvases: Int = tvEnvases.text.toString().toInt()
                updatedEnvases = updatedEnvases + etEnvases.text.toString().toInt()

                db2.collection(globalEmail + "-clientes").document(tvNombre.text.toString()).set(
                    hashMapOf(
                        "nombre" to tvNombre.text.toString(),
                        "apodo" to tvApodo.text.toString(),
                        "fiado" to tvFiado.text.toString(),
                        "envases" to updatedEnvases.toString()
                    )
                )
                val intent = Intent(this, Envases::class.java)
                startActivity(intent)
            }
        }

        btnDevolver.setOnClickListener {
            if(etEnvases.text.isEmpty() || (etEnvases.text.toString().toInt()>tvEnvases.text.toString().toInt())){
                Toast.makeText(this,"Ingresa una cantidad de Envases válida",Toast.LENGTH_SHORT).show()
            }
            else {
                var updatedEnvases: Int = tvEnvases.text.toString().toInt()
                updatedEnvases = updatedEnvases - etEnvases.text.toString().toInt()

                db2.collection(globalEmail + "-clientes").document(tvNombre.text.toString()).set(
                    hashMapOf(
                        "nombre" to tvNombre.text.toString(),
                        "apodo" to tvApodo.text.toString(),
                        "fiado" to tvFiado.text.toString(),
                        "envases" to updatedEnvases.toString()
                    )
                )
                val intent = Intent(this, Envases::class.java)
                startActivity(intent)
            }
        }

    }

    private fun initView() {
        tvNombre = findViewById(R.id.tvNombreEditarEnvases)
        tvApodo = findViewById(R.id.tvApodoEditarEnvases)
        tvEnvases = findViewById(R.id.tvEnvasesEditarEnvases)
        tvFiado = findViewById(R.id.tvFiadoEditarEnvases)
        btnCancelar = findViewById(R.id.btnCancelarEditarEnvases)
        btnDevolver = findViewById(R.id.btnDevolverEditarEnvases)
        btnPrestar = findViewById(R.id.btnPrestarEditarEnvases)
        etEnvases = findViewById(R.id.etEnvasesEditarEnvases)
    }

    private fun setValuesToViews(){
        tvNombre.text = intent.getStringExtra("nombre")
        tvApodo.text = intent.getStringExtra("apodo")
        tvEnvases.text = intent.getStringExtra("envases")
        tvFiado.text = intent.getStringExtra("fiado")
    }
}