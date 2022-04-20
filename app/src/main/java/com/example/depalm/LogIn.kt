package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.depalm.databinding.ActivityAuthenicationBinding
import com.google.firebase.auth.FirebaseAuth

lateinit var globalEmail: String

class LogIn : AppCompatActivity() {

    private lateinit var binding:ActivityAuthenicationBinding
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenicationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonRegistrar.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.buttonAcceder.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        globalEmail = email
                        val intent = Intent(this, MenuPrincipalAdmin::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this, it.exception.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }else{
                Toast.makeText(this,"No se permiten campos vacíos",
                Toast.LENGTH_SHORT).show()
            }
        }
    }


}