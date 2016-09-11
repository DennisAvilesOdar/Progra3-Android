package com.luisarceparedes.enviardatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class verSitioWeb extends AppCompatActivity {

    TextView lblSitioWeb;
    WebView wvSitioWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_sitio_web);

        lblSitioWeb = (TextView) findViewById(R.id.lblSitioWeb);
        wvSitioWeb = (WebView) findViewById(R.id.wvSitioWeb);

//        recoger los parametros enviados por el activityMain
        Bundle parametros = getIntent().getExtras();

        String sitioWeb = parametros.getString("sitio_web");
        lblSitioWeb.setText(sitioWeb);
        wvSitioWeb.loadUrl("http://" + sitioWeb);

    }
}
