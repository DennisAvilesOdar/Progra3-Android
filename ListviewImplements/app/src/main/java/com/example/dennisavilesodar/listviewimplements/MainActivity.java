package com.example.dennisavilesodar.listviewimplements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String listaNombres[] = {"Java","PHP","Python","JavaScript","Ruby","C"};
    private String listaImagenes[] =
            {       "http://progra2.herokuapp.com/imgs-lang/java.png",
                    "http://progra2.herokuapp.com/imgs-lang/php.png",
                    "http://progra2.herokuapp.com/imgs-lang/python.png",
                    "http://progra2.herokuapp.com/imgs-lang/javascript.png",
                    "http://progra2.herokuapp.com/imgs-lang/ruby.png",
                    "http://progra2.herokuapp.com/imgs-lang/c.png"
            };

    ListView lvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Funciones.habilitarDirectivasInternet();
        lvListado = (ListView)findViewById(R.id.lvListado);
        AdaptadorListado adaptadorListado = new AdaptadorListado(this,listaNombres,listaImagenes);
        lvListado.setAdapter(adaptadorListado);
    }
}
