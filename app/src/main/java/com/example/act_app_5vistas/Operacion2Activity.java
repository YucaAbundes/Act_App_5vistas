package com.example.act_app_5vistas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Operacion2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion2);

        final EditText edtCateto1 = findViewById(R.id.edtCateto1);
        final EditText edtCateto2 = findViewById(R.id.edtCateto2);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        final TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnRegresarOperacion2 = findViewById(R.id.btnRegresarOperacion2);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtén las longitudes de los catetos ingresados
                    double cateto1 = Double.parseDouble(edtCateto1.getText().toString());
                    double cateto2 = Double.parseDouble(edtCateto2.getText().toString());

                    // Calcula la hipotenusa usando el Teorema de Pitágoras
                    double hipotenusa = calcularHipotenusa(cateto1, cateto2);

                    // Muestra el resultado
                    txtResultado.setText("Hipotenusa según el Teorema de Pitágoras: " + hipotenusa);

                    // Oculta el teclado virtual
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtCateto2.getWindowToken(), 0);
                } catch (NumberFormatException e) {
                    // Maneja el caso en el que la entrada no sea un número válido
                    txtResultado.setText("Ingresa longitudes válidas para los catetos");
                }
            }
        });
        btnRegresarOperacion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresa a la pantalla principal
                finish();
            }
        });
    }

    private double calcularHipotenusa(double cateto1, double cateto2) {
        // Fórmula del Teorema de Pitágoras: c^2 = a^2 + b^2
        return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
    }
}
