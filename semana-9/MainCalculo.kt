package com.tallerapp.evaluacion9

import android.R.id.input
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random //Usada para la obtención de la temperatura


class MainCalculo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dist)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Definición de los elementos visuales del programa que se usarán en el backend
        val valorCompra = findViewById<EditText> (R.id.valorCompra)
        val distDespacho = findViewById<EditText>(R.id.distDespacho)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val resultadoTv = findViewById<TextView>(R.id.resultadoTv)
        val tempTv = findViewById<TextView>(R.id.tempTv)

        // Activa el funcionamiento del botón calcular
        btnCalcular.setOnClickListener {

            /*
            - Al ser presionado el botón el sistema automaticamente realiza la siguiente operación
              para entregar el valor final de la compra
            - Definición de variables internas que se usarán para realizar la operación matemáticas
            - El uso de text.toString().tonInt() es para señalar que los valores numéricos ingresados
              se deben utilizar en las operaciones
            */

            val total1 = valorCompra.text.toString().toInt()
            val total2 = valorCompra.text.toString().toInt() + (distDespacho.text.toString().toInt() * 150)
            val total3 = valorCompra.text.toString().toInt() + (distDespacho.text.toString().toInt() * 300)
            // Variable simulada para entregar la temperatura a la que se encuentra el camion
            val temp = Random.nextInt (40)

            //Definición de condiciones que se usarán según se cumplan las reglas del negocio
            if (distDespacho.text.toString().toInt() > 20){
                resultadoTv.text = "Usted se encuentra a una distancia mayor de nuestra área de despacho"
            } else if (valorCompra.text.toString().toInt() >= 50000) {
                resultadoTv.text = "El valor final de su compra es de: $"+total1
                tempTv.text = "La temperatura de su camion es de: "+temp +"º"
            } else if (valorCompra.text.toString().toInt() in 25000..49999) {
                resultadoTv.text = "El valor final de su compra es de: $"+total2
                tempTv.text = "La temperatura de su camion es de: "+temp +"º"
            } else if (valorCompra.text.toString().toInt() in 1..24999) {
                resultadoTv.text = "El valor final de su compra es de: $"+total3
                tempTv.text = "La temperatura de su camion es de: "+temp +"º"
            }

        }
    }
}