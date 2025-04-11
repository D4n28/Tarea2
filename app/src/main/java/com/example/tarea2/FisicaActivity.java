package com.example.tarea2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class FisicaActivity extends AppCompatActivity {

    EditText inputValor;
    Spinner spinnerConversion;
    Button btnConvertir;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);

        inputValor = findViewById(R.id.inputValor);
        spinnerConversion = findViewById(R.id.spinnerConversion);
        btnConvertir = findViewById(R.id.btnConvertir);
        resultado = findViewById(R.id.resultadoFisica);

        String[] opciones = {"Metros a Kilómetros", "Kilómetros a Metros"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConversion.setAdapter(adapter);

        btnConvertir.setOnClickListener(v -> {
            try {
                double valor = Double.parseDouble(inputValor.getText().toString());
                String seleccion = spinnerConversion.getSelectedItem().toString();
                double resultadoFinal;

                if (seleccion.equals("Metros a Kilómetros")) {
                    resultadoFinal = valor / 1000;
                } else {
                    resultadoFinal = valor * 1000;
                }

                resultado.setText("Resultado: " + resultadoFinal);
            } catch (NumberFormatException e) {
                resultado.setText("Ingresa un valor válido");
            }
        });
    }
}

