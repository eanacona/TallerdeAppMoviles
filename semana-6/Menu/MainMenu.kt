package com.tallerapp.evaluacion6

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
        setContentView(R.layout.activity_main_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botondespacho = findViewById<Button>(R.id.botondespacho)
        val botonradianes = findViewById<Button>(R.id.botonradianes)
        val botonGPS = findViewById<Button>(R.id.botonGPS)
        val regloc = findViewById<Button>(R.id.regloc)

        botondespacho.setOnClickListener {
            val intent1 = Intent(this, MainDespacho::class.java)
            startActivity(intent1)
        }

        botonradianes.setOnClickListener {
            val intent2 = Intent(this, MainRadianes::class.java)
            startActivity(intent2)
        }

        botonGPS.setOnClickListener {
            val intent3 = Intent(this, MainGps::class.java)
            startActivity(intent3)
        }

        regloc.setOnClickListener {
            val intent4 = Intent(this, MainRegloc::class.java)
            startActivity(intent4)
        }

    }
}