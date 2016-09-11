package com.luisarceparedes.enviardatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtWeb;
    Button btnVisitar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWeb = (EditText) findViewById(R.id.txtWeb);
        btnVisitar = (Button) findViewById(R.id.btnVisitar);

        btnVisitar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String direccion = txtWeb.getText().toString();
//        para configurar el parametro a enviar

        Bundle parametros = new Bundle();

        parametros.putString("sitio_web", direccion);

//        instanciando la pantalla verSitioWeb
        Intent pantallaSitioWeb = new Intent(this, verSitioWeb.class);

//        enviando los parametros a la pantalla verSitioWeb
        pantallaSitioWeb.putExtras(parametros);

//        Mostrar en pantalla al activity verSitioWeb
        startActivity(pantallaSitioWeb);



    }
}
