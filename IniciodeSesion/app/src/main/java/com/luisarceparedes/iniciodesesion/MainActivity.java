package com.luisarceparedes.iniciodesesion;

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

    Button btnIngresar;
    Spinner spnUsuario;
    EditText txtClave;
    Object usuario[][] = new Object[3][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        spnUsuario = (Spinner)findViewById(R.id.spnUsuario);
        txtClave = (EditText)findViewById(R.id.txtClave);

        btnIngresar.setOnClickListener(this);
        spnUsuario.setOnItemSelectedListener(this);

        cargarSpinnerUsuario();
    }

    private void cargarSpinnerUsuario(){
        usuario[0][0] = "Luis Antonio";
        usuario[0][1] = "usat2016";
        usuario[1][0] = "Raul Michael";
        usuario[1][1] = "usat2016";
        usuario[2][0] = "Ela Milagros";
        usuario[2][1] = "usat2016";

        String articulosSpiner[] = new String[usuario.length];

        for(int i=0; i < usuario.length; i++){
            articulosSpiner[i] = usuario[i][0].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, articulosSpiner);
        spnUsuario.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        int pos = spnUsuario.getSelectedItemPosition();
        String us = spnUsuario.getSelectedItem().toString();
        String cl = txtClave.getText().toString();


        if (cl.equals(usuario[pos][1].toString())){
//            aqui entra cuando es correcto

            Bundle parametros = new Bundle();
            parametros.putString("usuario", us);
            Intent menu = new Intent(this, frmMenu.class);
            menu.putExtras(parametros);
            startActivity(menu);
            

        }else {
//            y aqui cuando no
            Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
