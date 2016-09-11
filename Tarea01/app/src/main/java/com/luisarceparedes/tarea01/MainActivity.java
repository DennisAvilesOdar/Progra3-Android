package com.luisarceparedes.tarea01;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{


    RadioButton rbContado, rbCredito;
    Spinner spArticulos;
    TextView lblPrecio;
    EditText txtCantidad, txtDescuento;
    CheckBox cbDescuento;
    Button btnCalcular;

    Object articulo[][] = new Object[3][3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbContado = (RadioButton) findViewById(R.id.rbContado);
        rbCredito = (RadioButton) findViewById(R.id.rbCredito);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        txtDescuento = (EditText) findViewById(R.id.txtDescuento);
        cbDescuento = (CheckBox) findViewById(R.id.cbDescuento);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        spArticulos = (Spinner) findViewById(R.id.spArticulos);

        btnCalcular.setOnClickListener(this);
        spArticulos.setOnItemSelectedListener(this);
        rbCredito.setChecked(true);
        cargarArticulosSpinner();

        txtDescuento.setVisibility(View.GONE);


        cbDescuento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    txtDescuento.setVisibility(View.VISIBLE);
                } else {
                    txtDescuento.setVisibility(View.GONE);
                }
            }
        });

        rbCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String art = spArticulos.getSelectedItem().toString();
                for(int i = 0; i < articulo.length; i++){
                    if(art.equalsIgnoreCase(articulo[i][0].toString())){
                        double precio = Double.parseDouble(articulo[i][1].toString());
                        lblPrecio.setText(String.valueOf(precio));
                    }
                }
            }
        });
        rbContado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String art = spArticulos.getSelectedItem().toString();
                for(int i = 0; i < articulo.length; i++){
                    if(art.equalsIgnoreCase(articulo[i][0].toString())){
                        double precio = Double.parseDouble(articulo[i][2].toString());
                        lblPrecio.setText(String.valueOf(precio));
                    }
                }
            }
        });
    }

    private void cargarArticulosSpinner(){

        articulo[0][0] = "Cafetera Imaco Negra";
        articulo[0][1] = 155.50;
        articulo[0][2] = 160.00;
        articulo[1][0] = "Tostadora Imaco Negra";
        articulo[1][1] = 70.0;
        articulo[1][2] = 75.0;
        articulo[2][0] = "Microondas Samsung Negro";
        articulo[2][1] = 400.0;
        articulo[2][2] = 410.0;
        articulo[2][0] = "Frigobar Electrolux Plateado";
        articulo[2][1] = 640.0;
        articulo[2][2] = 650.0;

        String articulosSpiner[] = new String[articulo.length];

        for(int i=0; i < articulo.length; i++){
            articulosSpiner[i] = articulo[i][0].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, articulosSpiner);
        spArticulos.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        double desc = 0.0;
        if(cbDescuento.isChecked()){
            desc = Double.parseDouble(txtDescuento.getText().toString());
        }

        double cantidad = Double.parseDouble(txtCantidad.getText().toString());
        double precio = Double.parseDouble(lblPrecio.getText().toString());
        double neto = (cantidad * precio) - desc;
        String resultado = "El neto es " + String.valueOf(neto);

        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        double precio = 0.0;
        if(rbCredito.isChecked()){
            precio = Double.parseDouble(articulo[position][1].toString());
        }else if(rbContado.isChecked()){
            precio = Double.parseDouble(articulo[position][2].toString());
        }
        lblPrecio.setText(String.valueOf(precio));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



/*
*
*    playButton = (Button) findViewById(R.id.play);
*    playButton.setVisibility(1);
*    playButton.setOnClickListener(new OnClickListener() {
*        @Override
*        public void onClick(View v) {
*            //when play is clicked show stop button and hide play button
*            playButton.setVisibility(View.GONE);
*            stopButton.setVisibility(View.VISIBLE);
*        }
*    });
*
*
*    -->  rbSumar.isChecked()
*
* */