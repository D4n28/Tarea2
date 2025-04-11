package com.example.tarea2;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class EstadisticaActivity extends AppCompatActivity {

    EditText inputNumeros;
    Spinner spinnerEstadistica;
    Button btnCalcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        inputNumeros = findViewById(R.id.inputNumeros);
        spinnerEstadistica = findViewById(R.id.spinnerEstadistica);
        btnCalcular = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.resultadoEstadistica);

        String[] opciones = {"Media", "Mediana", "Moda"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstadistica.setAdapter(adapter);

        btnCalcular.setOnClickListener(v -> {
            try {
                String[] partes = inputNumeros.getText().toString().split(",");
                List<Double> numeros = new ArrayList<>();
                for (String p : partes) {
                    numeros.add(Double.parseDouble(p.trim()));
                }

                String seleccion = spinnerEstadistica.getSelectedItem().toString();
                double resultadoFinal = 0;

                switch (seleccion) {
                    case "Media":
                        resultadoFinal = calcularMedia(numeros);
                        resultado.setText("Media: " + resultadoFinal);
                        break;
                    case "Mediana":
                        resultadoFinal = calcularMediana(numeros);
                        resultado.setText("Mediana: " + resultadoFinal);
                        break;
                    case "Moda":
                        List<Double> moda = calcularModa(numeros);
                        resultado.setText("Moda: " + moda.toString());
                        break;
                }

            } catch (Exception e) {
                resultado.setText("Error: verifica el formato (ej. 1, 2, 3)");
            }
        });
    }

    private double calcularMedia(List<Double> nums) {
        double suma = 0;
        for (double n : nums) suma += n;
        return suma / nums.size();
    }

    private double calcularMediana(List<Double> nums) {
        Collections.sort(nums);
        int n = nums.size();
        if (n % 2 == 0)
            return (nums.get(n/2 - 1) + nums.get(n/2)) / 2;
        else
            return nums.get(n/2);
    }

    private List<Double> calcularModa(List<Double> nums) {
        Map<Double, Integer> freq = new HashMap<>();
        for (double n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        int maxFreq = Collections.max(freq.values());
        List<Double> modas = new ArrayList<>();

        for (Map.Entry<Double, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modas.add(entry.getKey());
            }
        }

        return modas;
    }
}
