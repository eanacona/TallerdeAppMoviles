package com.tallerapp.evaluacion6;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainRadianes extends AppCompatActivity {

    EditText vlrrad;
    TextView tot;
    double valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radianes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vlrrad = findViewById(R.id.valor2);
        tot = findViewById(R.id.rslradianes);
    }

    // Clase que calcula la conversión de números decimales a radianes
    public void radianes(View view) {
        valor = Double.parseDouble(vlrrad.getText().toString());

        double totalrad = valor * Math.PI / 180.0;
        tot.setText("Su valor en radianes es: " + totalrad);
    }
}