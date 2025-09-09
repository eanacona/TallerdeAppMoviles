package com.tallerapp.transporteapp;

import static java.lang.Math.random;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText email, dts, vlr, vlr2; // identificador de las variables en la interface gráfica
    TextView tot, tot2; // System print out en android
    int distancia, valor, total1, total2, total3, temp; //variables con las cuales funciona el código
    double valor2, total4; //variables con las cuales funciona el código

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //conector entre las variables de java y la interface física que se ejecuta en el celular
        dts = findViewById(R.id.distancia);
        vlr = findViewById(R.id.valor);
        tot = findViewById(R.id.resultado);
        vlr2 = findViewById(R.id.valor2);
        tot2 = findViewById(R.id.rslradianes);

    }
    // clase que calcula el despacho según las reglas del negocio
    public void calcular(View view){
        distancia = Integer.parseInt(dts.getText().toString());
        valor = Integer.parseInt(vlr.getText().toString());

        int total1 = valor;
        int total2 = valor + (distancia * 150);
        int total3 = valor + (distancia * 200);
        int temp = (int)(random() * 30) + 1; // Solución temporal para poder señalar la temperatura del camion, según los requerimientos del ejercicio, pensar en un metodo real de medición de la temperatura

        if (distancia > 20){
            tot.setText("La distancia de despacho no es validad");
        } else if (valor >= 50000) {
            tot.setText("El valor final de su compra es: "+total1 +"la temperatura del camion es: "+temp +"grados");
        } else if (valor >= 25000 && valor <= 49999) {
            tot.setText("El valor final de su compra es: "+total2 +"la temperatura del camion es: "+temp +"grados");
        } else if (valor >= 1 && valor <= 24999) {
            tot.setText("El valor final de su compra es: "+total3 +"la temperatura del camion es: "+temp +"grados");
        }

    }
    // Clase que calcula la conversión de números decimales a radianes
    public void radianes(View view){
        valor2 = Double.parseDouble(vlr2.getText().toString());

        double total4 = valor2 * Math.PI / 180.0;
        tot2.setText("Su valor en radianes es: "+total4);

    }

}