package com.example.act_app_5vistas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Operacion4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion4);

        final EditText edtNumero = findViewById(R.id.edtNumero);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        final TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnRegresarOperacion4 = findViewById(R.id.btnRegresarOperacion4);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtén el número ingresado
                    double numero = Double.parseDouble(edtNumero.getText().toString());

                    // Calcula la raíz cuadrada
                    double raizCuadrada = calcularRaizCuadrada(numero);

                    // Muestra el resultado
                    txtResultado.setText("Raíz cuadrada de " + numero + ": " + raizCuadrada);

                    // Oculta el teclado virtual
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtNumero.getWindowToken(), 0);
                } catch (NumberFormatException e) {
                    // Maneja el caso en el que la entrada no sea un número válido
                    txtResultado.setText("Ingresa un número válido");
                }
            }
        });
        btnRegresarOperacion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresa a la pantalla principal
                finish();
            }
        });
    }

    private double calcularRaizCuadrada(double numero) {
        // Utiliza la función Math.sqrt para calcular la raíz cuadrada
        return Math.sqrt(numero);
    }
}
