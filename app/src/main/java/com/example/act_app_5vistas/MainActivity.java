// Paquete de la aplicación
package com.example.act_app_5vistas;

// Importaciones
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Clase principal que extiende de AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Método llamado al crear la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Establece el diseño de la actividad desde el archivo XML
        setContentView(R.layout.activity_main);

        // Obtiene referencias a los botones en el diseño
        Button btnOperacion1 = findViewById(R.id.btnOperacion1);
        Button btnOperacion2 = findViewById(R.id.btnOperacion2);
        Button btnOperacion3 = findViewById(R.id.btnOperacion3);
        Button btnOperacion4 = findViewById(R.id.btnOperacion4);
        Button btnOperacion5 = findViewById(R.id.btnOperacion5);

        // Asigna un listener al botón Operacion
        btnOperacion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre la actividad correspondiente a Operacion1
                abrirActividadOperacion(Operacion1Activity.class);
            }
        });

        // Asigna un listener al botón Operacion
        btnOperacion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividadOperacion(Operacion2Activity.class);
            }
        });

        btnOperacion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividadOperacion(Operacion3Activity.class);
            }
        });

        btnOperacion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividadOperacion(Operacion4Activity.class);
            }
        });

        btnOperacion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividadOperacion(Operacion5Activity.class);
            }
        });
    }

    // Método privado para abrir una nueva actividad
    private void abrirActividadOperacion(Class<?> cls) {
        // Crea un intent para abrir la actividad deseada
        Intent intent = new Intent(MainActivity.this, cls);

        // Inicia la actividad
        startActivity(intent);
    }
}
