package com.luisarceparedes.app01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtNombre;
    Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnSaludar = (Button) findViewById(R.id.btnSaludar);

        /*configuara para que el boton brnSlaudar responfa al evento click*/
        btnSaludar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String nombre = txtNombre.getText().toString();

        Toast.makeText(this, "Hola! " + nombre + " este es un saludo desde android.", Toast.LENGTH_LONG).show();
    }
}
