package com.example.act_app_5vistas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Operacion1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion1);

        final EditText edtRadio = findViewById(R.id.edtRadio);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        final TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnRegresarOperacion1 = findViewById(R.id.btnRegresarOperacion1);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtén el radio ingresado
                    double radio = Double.parseDouble(edtRadio.getText().toString());

                    // Calcula la circunferencia del círculo
                    double circunferencia = calcularCircunferencia(radio);

                    // Muestra el resultado
                    txtResultado.setText("Circunferencia del círculo con radio " + radio + ": " + circunferencia);

                    // Oculta el teclado virtual
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtRadio.getWindowToken(), 0);
                } catch (NumberFormatException e) {
                    // Maneja el caso en el que la entrada no sea un número válido
                    txtResultado.setText("Ingresa un radio válido");
                }
            }
        });

        btnRegresarOperacion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresa a la pantalla principal
                finish();
            }
        });
    }

    private double calcularCircunferencia(double radio) {
        // Fórmula para calcular la circunferencia del círculo: C = 2 * π * radio
        return 2 * Math.PI * radio;
    }
}
