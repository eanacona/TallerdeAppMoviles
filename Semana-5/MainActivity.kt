package com.tallerapp.semana5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

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

        val botondespacho = findViewById<Button>(R.id.botondespacho)
        val botonradianes = findViewById<Button>(R.id.botonradianes)
        val botonGPS = findViewById<Button>(R.id.botonGPS)

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

    }
}

