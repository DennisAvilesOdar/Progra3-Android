package com.luisarceparedes.multitarea;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar pbarProgreso;
    Button btnSinHilos, btnConHilos, btnEjecutarOtraTarea, btnAsyncTask, btnCancelarAsyncTask;
    MiTareaOrdenamiento tarea1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbarProgreso = (ProgressBar)findViewById(R.id.pbarProgreso);
        btnConHilos = (Button)findViewById(R.id.btnConHilos);
        btnSinHilos = (Button)findViewById(R.id.btnSinHilos);
        btnEjecutarOtraTarea = (Button)findViewById(R.id.btnEjecutarOtraTarea);
        btnAsyncTask = (Button)findViewById(R.id.btnAsyncTask);
        btnCancelarAsyncTask = (Button)findViewById(R.id.btnCancelarAsyncTask);

        btnSinHilos.setOnClickListener(this);
        btnConHilos.setOnClickListener(this);
        btnEjecutarOtraTarea.setOnClickListener(this);
        btnAsyncTask.setOnClickListener(this);
        btnCancelarAsyncTask.setOnClickListener(this);
    }

    private void demora1ms(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnSinHilos:

                pbarProgreso.setMax(100);

                pbarProgreso.setProgress(0);

                int numbers[] = Numeros.listaNumeros;
                int aux;
                double porc;
                for (int i = 0; i < numbers.length - 1; i++) {
                    for (int j = 0; j < numbers.length -1; j++) {
                        if (numbers[j] > numbers[j+1]) {
                            aux          = numbers[j];
                            numbers[j]   = numbers[j+1];
                            numbers[j+1] = aux;
                        }
                    }
                    porc = Math.ceil(((double) i / (double)numbers.length)*100);
                    System.out.println(porc + "%");
                    pbarProgreso.setProgress((int)porc);
                    demora1ms();
                }

                Toast.makeText(this, "Numero Ordenados", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnConHilos:

                pbarProgreso.setMax(100);
                pbarProgreso.setProgress(0);

                new Thread(new Runnable() {
                    public void run() {

//                        Tarea larga
                        int numbers[] = Numeros.listaNumeros;
                        int aux;
                        double porc;
                        for (int i = 0; i < numbers.length - 1; i++) {
                            for (int j = 0; j < numbers.length -1; j++) {
                                if (numbers[j] > numbers[j+1]) {
                                    aux          = numbers[j];
                                    numbers[j]   = numbers[j+1];
                                    numbers[j+1] = aux;
                                }
                            }
                            porc = Math.ceil(((double) i / (double)numbers.length)*100);
                            System.out.println(porc + "%");
                            pbarProgreso.setProgress((int)porc);
                        }
//                        Tarea larga

                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getBaseContext(), "¡Números Ordenados!", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();

                break;
            case R.id.btnEjecutarOtraTarea:
                Toast.makeText(getBaseContext(), "olah", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnAsyncTask:
                tarea1 = new MiTareaOrdenamiento();
                tarea1.execute();
                break;
            case R.id.btnCancelarAsyncTask:
                tarea1.cancel(true);
                break;
        }

    }

    private class MiTareaOrdenamiento extends AsyncTask<Void, Integer, Boolean>{
        @Override
        protected void onPreExecute() {
            pbarProgreso.setMax(100);
            pbarProgreso.setProgress(0);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            int numbers[] = Numeros.listaNumeros;
            int aux;
            double porc;
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length -1; j++) {
                    if (numbers[j] > numbers[j+1]) {
                        aux          = numbers[j];
                        numbers[j]   = numbers[j+1];
                        numbers[j+1] = aux;
                    }
                }
                porc = Math.ceil(((double) i / (double)numbers.length)*100);
                System.out.println(porc + "%");
                publishProgress((int)porc);
                demora1ms();
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();
            pbarProgreso.setProgress(progreso);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result){
                Toast.makeText(getBaseContext(), "¡Números Ordenados!", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(getBaseContext(), "La tarea se ha cancelado...", Toast.LENGTH_LONG).show();
        }
    }

}
