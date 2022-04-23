package com.example.depalm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Envases : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_envases)

        val botonVolver: ImageButton = findViewById(R.id.button_volver7)

        botonVolver.setOnClickListener {
            val intent = Intent(this, MenuPrincipalAdmin::class.java)
            startActivity(intent)
        }
    }


}