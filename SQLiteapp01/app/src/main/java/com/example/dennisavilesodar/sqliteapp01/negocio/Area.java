package com.example.dennisavilesodar.sqliteapp01.negocio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dennisavilesodar.sqliteapp01.datos.AccesoDatos;

import java.util.ArrayList;

/**
 * Created by dennisavilesodar on 9/15/16.
 */
public class Area extends AccesoDatos{

    private int codigoArea;
    private int codigoDepartamento;
    private String nombre;

    public static ArrayList<Area> listaArea = new ArrayList<Area>();

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void cargarDatosArea(int codigoDepartamento){
        SQLiteDatabase bd = this.getReadableDatabase();
        String sql = "select * from area where codigo_departamento = " + codigoDepartamento +" order by 2";
        Cursor resultado = bd.rawQuery(sql,null);

        listaArea.clear();

        while(resultado.moveToNext()){
            Area objArea = new Area();
            objArea.setCodigoArea(resultado.getInt(0));
            objArea.setNombre(resultado.getString(1));
            listaArea.add(objArea);
        }
    }
    public String[] listaArea(int codigoDepartamento){
        cargarDatosArea(codigoDepartamento);
        String listaNombresArea[] = new String[listaArea.size()];
        for (int i = 0; i<listaArea.size(); i++){
            Area item = listaArea.get(i);
            listaNombresArea[i] = item.getNombre();
        }

        return listaNombresArea;
    }
}
