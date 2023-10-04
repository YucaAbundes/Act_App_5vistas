// Operacion5Activity.java
package com.example.act_app_5vistas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Operacion5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion5);

        final EditText edtParteReal1 = findViewById(R.id.edtParteReal1);
        final EditText edtParteImaginaria1 = findViewById(R.id.edtParteImaginaria1);
        final EditText edtParteReal2 = findViewById(R.id.edtParteReal2);
        final EditText edtParteImaginaria2 = findViewById(R.id.edtParteImaginaria2);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        final TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnRegresarOperacion5 = findViewById(R.id.btnRegresarOperacion5);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtén las partes reales e imaginarias ingresadas
                    double parteReal1 = Double.parseDouble(edtParteReal1.getText().toString());
                    double parteImaginaria1 = Double.parseDouble(edtParteImaginaria1.getText().toString());
                    double parteReal2 = Double.parseDouble(edtParteReal2.getText().toString());
                    double parteImaginaria2 = Double.parseDouble(edtParteImaginaria2.getText().toString());

                    // Realiza la operación con números complejos
                    String resultado = realizarOperacionNumerosComplejos(parteReal1, parteImaginaria1, parteReal2, parteImaginaria2);

                    // Muestra el resultado
                    txtResultado.setText(resultado);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);


                } catch (NumberFormatException e) {
                    // Maneja el caso en el que la entrada no sea un número válido
                    txtResultado.setText("Ingresa números válidos para las partes reales e imaginarias");
                }
            }
        });

        btnRegresarOperacion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresa a la pantalla principal
                finish();
            }
        });
    }

    private String realizarOperacionNumerosComplejos(double parteReal1, double parteImaginaria1, double parteReal2, double parteImaginaria2) {
        // Realiza la operación con números complejos (puedes implementar tu propia lógica)
        // En este ejemplo, simplemente suma las partes reales e imaginarias
        double resultadoParteReal = parteReal1 + parteReal2;
        double resultadoParteImaginaria = parteImaginaria1 + parteImaginaria2;

        return "Resultado: " + resultadoParteReal + " + " + resultadoParteImaginaria + "i";
    }
}
