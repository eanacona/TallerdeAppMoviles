package com.tallerapp.evaluacion9

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dist)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Identificador del botón táctil
        val btnIngreso = findViewById<Button>(R.id.btnIngreso)

        // Comando que permite pasar de la actividad inicial a la actividad menú
        btnIngreso.setOnClickListener {
            val ingreso = Intent(this, MainMenu::class.java)
            startActivity(ingreso)
        }
    }
}