package com.example.dennisavilesodar.sqliteapp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.dennisavilesodar.sqliteapp01.datos.AccesoDatos;
import com.example.dennisavilesodar.sqliteapp01.negocio.Area;
import com.example.dennisavilesodar.sqliteapp01.negocio.Departamento;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spDepartamento;
    Spinner spArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDepartamento = (Spinner)findViewById(R.id.spDepartamento);
        spArea = (Spinner)findViewById(R.id.spArea);

        spDepartamento.setOnItemSelectedListener(this);

        AccesoDatos.aplicacion = this;

        cargarDatosSpinnerDepartamento();

    }

    private void cargarDatosSpinnerDepartamento(){
        String listaNombreDepartamento[] = new Departamento().listaDepartamentos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,
                listaNombreDepartamento
        );

        spDepartamento.setAdapter(adapter);
    }

    private void cargarDatosSpinnerArea(int codigoDep){
        String listaNombreArea[] = new Area().listaArea(codigoDep);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,
                listaNombreArea
        );

        spArea.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.spDepartamento:
                int codigoDep = Departamento.listaDep.get(i).getCodigoDepartamento();
                cargarDatosSpinnerArea(codigoDep);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
