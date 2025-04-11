package com.example.tarea2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MatematicasActivity extends AppCompatActivity {

    EditText inputNum1, inputNum2;
    TextView resultado;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas);

        inputNum1 = findViewById(R.id.inputNum1);
        inputNum2 = findViewById(R.id.inputNum2);
        resultado = findViewById(R.id.resultadoMatematica);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(view -> operar('+'));
        btnRestar.setOnClickListener(view -> operar('-'));
        btnMultiplicar.setOnClickListener(view -> operar('*'));
        btnDividir.setOnClickListener(view -> operar('/'));
    }

    private void operar(char operacion) {
        try {
            double num1 = Double.parseDouble(inputNum1.getText().toString());
            double num2 = Double.parseDouble(inputNum2.getText().toString());
            double res = 0;

            switch (operacion) {
                case '+': res = num1 + num2; break;
                case '-': res = num1 - num2; break;
                case '*': res = num1 * num2; break;
                case '/':
                    if (num2 != 0) res = num1 / num2;
                    else {
                        resultado.setText("No se puede dividir por cero");
                        return;
                    }
                    break;
            }

            resultado.setText("Resultado: " + res);
        } catch (NumberFormatException e) {
            resultado.setText("Por favor ingresa ambos números correctamente");
        }
    }
}
