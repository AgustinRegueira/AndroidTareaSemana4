package edu.utec.tareasemana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddUserActivity extends AppCompatActivity {

    private EditText editNuevoNombre;
    private EditText editNuevoApellido;
    private Spinner comboNuevoRol;
    private EditText editNuevaFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editNuevoNombre = findViewById(R.id.editNuevoNombre);
        editNuevoApellido = findViewById(R.id.editNuevoApellido);
        comboNuevoRol = findViewById(R.id.comboNuevoRol);
        editNuevaFecha = findViewById(R.id.editNuevaFecha);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboNuevoRol.setAdapter(adapter);

        Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(view -> {
            Intent response = new Intent();
            if(TextUtils.isEmpty(editNuevoNombre.getText()) ||
                    TextUtils.isEmpty(editNuevoApellido.getText()) ||
                    TextUtils.isEmpty(editNuevaFecha.getText())){
                setResult(RESULT_CANCELED, response);
            } else {
                String nombre = editNuevoNombre.getText().toString();
                String apellido = editNuevoApellido.getText().toString();
                String fecha = editNuevaFecha.getText().toString();
                String rol = comboNuevoRol.getSelectedItem().toString();

                response.putExtra("NOMBRE", nombre);
                response.putExtra("APELLIDO", apellido);
                response.putExtra("ROL", rol);
                response.putExtra("FECHA", fecha);
                setResult(RESULT_OK, response);
            }
            finish();
        });
    }
}