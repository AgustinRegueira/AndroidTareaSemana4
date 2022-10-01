package edu.utec.tareasemana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ShowUserActivity extends AppCompatActivity {

    private EditText editShowNombre;
    private EditText editShowApellido;
    private EditText editShowRol;
    private EditText editShowFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        editShowNombre = findViewById(R.id.editShowNombre);
        editShowApellido = findViewById(R.id.editShowApellido);
        editShowRol = findViewById(R.id.editShowRol);
        editShowFecha = findViewById(R.id.editShowFecha);

        Intent intent = getIntent();
        editShowNombre.setText(intent.getStringExtra("NOMBRE"));
        editShowApellido.setText(intent.getStringExtra("APELLIDO"));
        editShowRol.setText(intent.getStringExtra("ROL"));
        editShowFecha.setText(intent.getStringExtra("FECHA"));
    }
}