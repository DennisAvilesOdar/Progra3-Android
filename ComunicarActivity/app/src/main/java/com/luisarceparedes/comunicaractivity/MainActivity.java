package com.luisarceparedes.comunicaractivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAcercaDe, btnTerminosyCondiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAcercaDe = (Button) findViewById(R.id.btnAcercaDe);
        btnTerminosyCondiciones = (Button)findViewById(R.id.btnTerminosyCondiciones);

        btnAcercaDe.setOnClickListener(this);
        btnTerminosyCondiciones.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAcercaDe:
                Intent pantalla = new Intent(this, AcercaDe.class);
                startActivity(pantalla);
                break;
            case R.id.btnTerminosyCondiciones:
                Intent pantalla2 = new Intent(this, TerminosyCondiciones.class);
                startActivity(pantalla2);
                break;
        }


    }
}
