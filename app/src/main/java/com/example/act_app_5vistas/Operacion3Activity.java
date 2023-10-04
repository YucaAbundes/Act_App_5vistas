// Operacion3Activity.java
package com.example.act_app_5vistas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Operacion3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion3);

        final EditText edtLado1 = findViewById(R.id.edtLado1);
        final EditText edtLado2 = findViewById(R.id.edtLado2);
        final EditText edtLado3 = findViewById(R.id.edtLado3);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        final TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnRegresarOperacion3 = findViewById(R.id.btnRegresarOperacion3);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtén las longitudes de los lados ingresados
                    double lado1 = Double.parseDouble(edtLado1.getText().toString());
                    double lado2 = Double.parseDouble(edtLado2.getText().toString());
                    double lado3 = Double.parseDouble(edtLado3.getText().toString());

                    // Calcula el perímetro de la figura
                    double perimetro = calcularPerimetro(lado1, lado2, lado3);

                    // Muestra el resultado
                    txtResultado.setText("Perímetro de la figura: " + perimetro);

                    // Oculta el teclado virtual
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtLado3.getWindowToken(), 0);
                } catch (NumberFormatException e) {
                    // Maneja el caso en el que la entrada no sea un número válido
                    txtResultado.setText("Ingresa longitudes válidas para los lados");
                }
            }
        });

        btnRegresarOperacion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresa a la pantalla principal
                finish();
            }
        });
    }

    private double calcularPerimetro(double... lados) {
        // Fórmula del perímetro: Suma de las longitudes de todos los lados
        double perimetro = 0;
        for (double lado : lados) {
            perimetro += lado;
        }
        return perimetro;
    }
}
