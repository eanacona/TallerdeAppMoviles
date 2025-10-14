package com.tallerapp.evaluacion9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dist)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Código que permite identificar a los  botones en la interface visual
        val btnGps = findViewById<Button>(R.id.btnGps)
        val btnCalculo = findViewById<Button>(R.id.btnCalculo)

        // Comando que permite pasar de la actividad menú a la actividad del mapa GPS
        btnGps.setOnClickListener {
            val intentGps = Intent(this, MainGps::class.java)
            startActivity(intentGps)
        }

        // Comando que permite pasar de la actividad menú a la actividad de cálculo del total de la compra
        btnCalculo.setOnClickListener {
            val intentCalculo = Intent (this, MainCalculo::class.java)
            startActivity(intentCalculo)
        }
    }
}