package com.luisarceparedes.app02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtN1, txtN2;
    RadioButton rbSumar, rbRestar, rbMultiplicar, rbDividir;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtN1 = (EditText) findViewById(R.id.txtN1);
        txtN2 = (EditText) findViewById(R.id.txtN2);


        rbSumar = (RadioButton)findViewById(R.id.rbSumar);
        rbRestar = (RadioButton)findViewById(R.id.rbRestar);
        rbMultiplicar = (RadioButton)findViewById(R.id.rbMultiplicar);
        rbDividir = (RadioButton)findViewById(R.id.rbDividir);


        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(txtN1.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese el N1", Toast.LENGTH_SHORT).show();
            return;
        }
        if(txtN2.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese el N2", Toast.LENGTH_SHORT).show();
            return;
        }

        int n1 = Integer.parseInt(txtN1.getText().toString());
        int n2 = Integer.parseInt(txtN2.getText().toString());

        String resultado = "";

        if(rbSumar.isChecked()){
            int suma = n1 + n2;
            resultado = "La suma es: " + suma;
        }else if(rbRestar.isChecked()){
            int resta = n1 - n2;
            resultado = "La resta es: " + resta;
        }else if(rbMultiplicar.isChecked()){
            int producto = n1 * n2;
            resultado = "El producto es: " + producto;
        }else{
            float nn1 = Float.parseFloat(txtN1.getText().toString());
            float nn2 = Float.parseFloat(txtN2.getText().toString());
            double div = nn1 / nn2;
            resultado = "La division es: " + div;
        }

        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
        System.out.println(resultado);
    }
}
