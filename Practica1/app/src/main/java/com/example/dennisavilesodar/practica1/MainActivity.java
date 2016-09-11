package com.example.dennisavilesodar.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnIngresar;
    Spinner spUsuario;
    Object usuario[][] = new Object[2][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        spUsuario = (Spinner)findViewById(R.id.spUsuario);

        btnIngresar.setOnClickListener(this);

        cargarSpinnerUsuarios();
    }

    @Override
    public void onClick(View view) {
        Intent otro = new Intent(view.getContext(), Main2Activity.class);
        startActivityForResult(otro, 0);
    }

    public void cargarSpinnerUsuarios(){
        usuario[0][0] = "admin";
        usuario[0][1] = 123;

        usuario[1][0] = "dennis";
        usuario[1][1] = 987;

        String articuloSpinner[] = new String [usuario.length];
        for (int i=0;i<usuario.length;i++){
            articuloSpinner[i] = usuario[i][0].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,articuloSpinner);
        spUsuario.setAdapter(adapter);
    }
}
