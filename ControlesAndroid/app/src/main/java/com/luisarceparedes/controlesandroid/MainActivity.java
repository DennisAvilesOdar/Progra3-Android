package com.luisarceparedes.controlesandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{


    //agregar layout horizontal: radioGroup: radioButtom1(contado), radioButtom2(credito)

    Spinner spArticulo;
    TextView lblPrecio, lblNeto;
    EditText txtCantidad;
    Button btnCalcular;
    Object articulo[][] = new Object[3][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spArticulo = (Spinner) findViewById(R.id.spArticulo);
        lblNeto = (TextView) findViewById(R.id.lblNeto);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);
        spArticulo.setOnItemSelectedListener(this);

        cargarSpinnerArticulo();


    }


    private void cargarSpinnerArticulo(){
        articulo[0][0] = "Gaseosa Coca COla x 1.5 litros";
        articulo[0][1] = 4.20;
        articulo[1][0] = "Yougurt Laive x 1 Kg Durazno";
        articulo[1][1] = 6.2;
        articulo[2][0] = "Turron x 1Kg";
        articulo[2][1] = 15.0;

        String articulosSpiner[] = new String[articulo.length];

        for(int i=0; i < articulo.length; i++){
            articulosSpiner[i] = articulo[i][0].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, articulosSpiner);
        spArticulo.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        double precio = Double.parseDouble(lblPrecio.getText().toString());
        int cantidad = Integer.parseInt(txtCantidad.getText().toString());
        double neto = precio * cantidad;

        lblNeto.setText(String.valueOf(neto));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        double precio = Double.parseDouble(articulo[position][1].toString());
        lblPrecio.setText(String.valueOf(precio));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
