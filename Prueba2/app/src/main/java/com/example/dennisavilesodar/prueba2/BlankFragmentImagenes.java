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


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentImagenes extends Fragment implements View.OnClickListener{


    Button btnImagenes;
    ImageView imageView1,imageView2,imageView3,imageView4;

    private static final String IMAGENES_1 = "http://vignette4.wikia.nocookie.net/vetealavershstar/images/6/68/Puchamon_Pitochu_by_killerman55.png/revision/latest?cb=20110409040010&path-prefix=es";
    private static final String IMAGENES_2 = "https://pbs.twimg.com/profile_images/616436517137809408/vxfN51TJ.jpg";
    private static final String IMAGENES_3 = "http://vetealaversh.com/wp-content/uploads/2015/08/0041.png";
    private static final String IMAGENES_4 = "https://pbs.twimg.com/profile_images/538228908508721152/pmuewX5R.png";

    public BlankFragmentImagenes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment_imagenes, container, false);

        btnImagenes = (Button)view.findViewById(R.id.btnImagenes);
        imageView1 = (ImageView)view.findViewById(R.id.imageView1);
        imageView2 = (ImageView)view.findViewById(R.id.imageView2);
        imageView3 = (ImageView)view.findViewById(R.id.imageView3);
        imageView4 = (ImageView)view.findViewById(R.id.imageView4);

        btnImagenes.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        cargarImagen tarea1 = new cargarImagen();
        tarea1.execute(IMAGENES_1);

        cargarImagen tarea2 = new cargarImagen();
        tarea2.execute(IMAGENES_2);

        cargarImagen tarea3 = new cargarImagen();
        tarea3.execute(IMAGENES_3);

        cargarImagen tarea4 = new cargarImagen();
        tarea4.execute(IMAGENES_4);
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
            imageView1.setImageBitmap(result);
            imageView2.setImageBitmap(result);
            imageView3.setImageBitmap(result);
            imageView4.setImageBitmap(result);
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
