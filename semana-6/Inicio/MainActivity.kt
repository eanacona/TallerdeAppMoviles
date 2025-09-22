package com.tallerapp.evaluacion6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonregister = findViewById<Button>(R.id.botonregister)
        val botonlogin = findViewById<Button>(R.id.botonlogin)

        botonregister.setOnClickListener {
            val intent1 = Intent(this, MainRegister::class.java)
            startActivity(intent1)
        }

        botonlogin.setOnClickListener {
            val intent2 = Intent(this, MainLogin::class.java)
            startActivity(intent2)
        }

    }
}