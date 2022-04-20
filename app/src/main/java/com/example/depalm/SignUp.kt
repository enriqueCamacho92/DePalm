package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.depalm.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var binding:ActivityRegistrationBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.imageButton.setOnClickListener{
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        binding.buttonRegistrar.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()
            val confirmPass = binding.editTextPassword4.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass==confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                val intent = Intent(this,LogIn::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }

                }else{
                    Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"No se permiten campos vacíos",Toast.LENGTH_SHORT).show()
            }
        }
    }
}