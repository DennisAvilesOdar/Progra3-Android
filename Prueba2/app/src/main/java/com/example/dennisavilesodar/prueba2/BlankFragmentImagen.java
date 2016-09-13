package com.example.dennisavilesodar.prueba2;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentImagen extends Fragment implements View.OnClickListener{

    Button btnImagen1,btnImagen2;
    ImageView imgImagen;

    private static final String IMAGEN_1 = "https://i.ytimg.com/vi/LVqI78fbeD0/maxresdefault.jpg";
    private static final String IMAGEN_2 = "http://vignette1.wikia.nocookie.net/vete-a-la-versh/images/0/08/Mecoboy.jpg/revision/latest?cb=20151220072557&path-prefix=es";


    public BlankFragmentImagen() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank_fragment_imagen, container, false);

        btnImagen1 = (Button) view.findViewById(R.id.btnImagen1);
        btnImagen2 = (Button) view.findViewById(R.id.btnImagen2);
        imgImagen = (ImageView) view.findViewById(R.id.imgImagen);


        btnImagen1.setOnClickListener(this);
        btnImagen2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnImagen1:
                cargarImagen tarea1 = new cargarImagen();
                tarea1.execute(IMAGEN_1);
                break;
            case R.id.btnImagen2:
                cargarImagen tarea2 = new cargarImagen();
                tarea2.execute(IMAGEN_2);
                break;
        }
    }

    private class cargarImagen extends AsyncTask<String, Void, Bitmap> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute(){
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Descargando Imagen");
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }
        @Override
        protected Bitmap doInBackground(String... params){
            String imagenDescargar = params[0];
            Bitmap imagenDescargada = descargarImagen(imagenDescargar);

            return imagenDescargada;
        }
        @Override
        protected void onPostExecute(Bitmap result){
            imgImagen.setImageBitmap(result);
            pDialog.dismiss();
        }
    }

    private Bitmap descargarImagen (String direccion){
        URL imagenUrl = null;
        Bitmap imgImagen = null;
        try {
            imagenUrl = new URL(direccion);
            HttpURLConnection conn = (HttpURLConnection)imagenUrl.openConnection();
            conn.connect();
            imgImagen = BitmapFactory.decodeStream(conn.getInputStream());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return imgImagen;
    }
}
