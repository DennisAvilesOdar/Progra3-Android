package com.luisarceparedes.cargaimagenes;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnCargarImagen;
    ImageView imgImagen;

    private static final String IMAGEN_DESCARGAR = "http://www.stm.edu.pe/2016/assets/images/convenios/usat.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCargarImagen = (Button)findViewById(R.id.btnCargarImagen);
        imgImagen = (ImageView)findViewById(R.id.imagen);

        btnCargarImagen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        cargarImagen tarea1 = new cargarImagen();
        tarea1.execute(IMAGEN_DESCARGAR);
    }

    private class cargarImagen extends AsyncTask<String, Void, Bitmap>{

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Descargando Imágen");
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            String imagenDescargar = params[0];
            Bitmap imagenDescargada = descargarImagen(imagenDescargar);

            return imagenDescargada;
        }



        @Override
        protected void onPostExecute(Bitmap result) {
            imgImagen.setImageBitmap(result);
            pDialog.dismiss();
        }

    }

    private Bitmap descargarImagen (String direccion){
        URL imageUrl = null;
        Bitmap imagen = null;
        try{
            imageUrl = new URL(direccion);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return imagen;
    }
}
