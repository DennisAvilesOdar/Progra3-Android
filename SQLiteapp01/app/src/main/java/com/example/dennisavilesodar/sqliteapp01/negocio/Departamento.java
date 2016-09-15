package com.example.dennisavilesodar.sqliteapp01.negocio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dennisavilesodar.sqliteapp01.datos.AccesoDatos;

import java.util.ArrayList;

/**
 * Created by dennisavilesodar on 9/15/16.
 */
public class Departamento extends AccesoDatos {

    private int codigoDepartamento;
    private String nombre;

    public static ArrayList<Departamento> listaDep = new ArrayList<Departamento>();

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

    private void cargarDatosDepartamento(){
        SQLiteDatabase bd = this.getReadableDatabase();
        String sql = "select * from departamento order by 2";
        Cursor resultado = bd.rawQuery(sql,null);

        listaDep.clear();

        while(resultado.moveToNext()){
            Departamento objDep = new Departamento();
            objDep.setCodigoDepartamento(resultado.getInt(0));
            objDep.setNombre(resultado.getString(1));
            listaDep.add(objDep);
        }
    }

    public String[] listaDepartamentos(){
        cargarDatosDepartamento();
        String listaNombresDepartamentos[] = new String[listaDep.size()];
        for (int i = 0; i<listaDep.size(); i++){
            Departamento item = listaDep.get(i);
            listaNombresDepartamentos[i] = item.getNombre();
        }

        return listaNombresDepartamentos;
    }
}
