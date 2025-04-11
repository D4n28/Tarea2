package com.example.tarea2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMatematicas, btnFisica, btnEstadistica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate que este XML existe

        btnMatematicas = findViewById(R.id.btnMatematicas);
        btnFisica = findViewById(R.id.btnFisica);
        btnEstadistica = findViewById(R.id.btnEstadistica);

        btnMatematicas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MatematicasActivity.class);
            startActivity(intent);
        });

        btnFisica.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FisicaActivity.class);
            startActivity(intent);
        });

        btnEstadistica.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EstadisticaActivity.class);
            startActivity(intent);
        });
    }
}

