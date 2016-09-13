package com.example.dennisavilesodar.prueba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Spinner spUsuario;
    EditText txtContraseña;
    Button btnIngresar;

    Object usuario[][] = new Object[2][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spUsuario = (Spinner) findViewById(R.id.spUsuario);
        txtContraseña = (EditText)findViewById(R.id.txtContraseña);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        cargarUsuarioSpinner();

        btnIngresar.setOnClickListener(this);
        spUsuario.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        int pos = spUsuario.getSelectedItemPosition();
        String us = spUsuario.getSelectedItem().toString();
        String cl = txtContraseña.getText().toString();

        if(cl.equals(usuario[pos][1].toString())){
            Bundle parametros = new Bundle();
            parametros.putString("usuario",us);
            Intent menu = new Intent(this, Main2Activity.class);
            menu.putExtras(parametros);
            startActivity(menu);
        }else{
            Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_LONG).show();
        }
    }

    private void cargarUsuarioSpinner(){

        usuario[0][0] = "admin";
        usuario[0][1] = 1234;
        usuario[1][0] = "Dennis";
        usuario[1][1] = 9876;

        String usuarioSpiner[] = new String[usuario.length];

        for(int i=0; i < usuario.length; i++){
            usuarioSpiner[i] = usuario[i][0].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, usuarioSpiner);
        spUsuario.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
