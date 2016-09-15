package com.example.dennisavilesodar.sqliteapp01.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dennisavilesodar on 9/15/16.
 */
public class AccesoDatos extends SQLiteOpenHelper {

    private static String nombreBD = "bdempresa";
    private static int versionBD = 1;

    /*Para referenciar la aplicacion donde se instalara la BD*/
    public static Context aplicacion;

    private static String tablaDepartamento = "create table departamento(codigo_departamento integer primary key, nombre varchar(50))";
    private static String tablaDepartamentoDatos[] =
            {
                    "insert into departamento values (1, 'FINANZAS')",
                    "insert into departamento values (2, 'COMERCIAL')"
            };

    private static String tablaArea = "create table area(codigo_area integer primary key, nombre varchar(50), codigo_departamento integer, Foreign key(codigo_departamento) references departamento(codigo_departamento))";
    private static String tablaAreaDatos[] =
            {
                    "insert into area values (1, 'CONTABILIDAD', 1)",
                    "insert into area values (2, 'TESORERIA', 1)",
                    "insert into area values (3, 'AUDITORIA CONTABLE', 1)",

                    "insert into area values (4, 'VENTAS', 2)",
                    "insert into area values (5, 'MARKETING', 2)",
                    "insert into area values (6, 'CANALES DE DISTRIBUCION', 2)"
            };

    public AccesoDatos(){
        super(aplicacion, nombreBD,null,versionBD);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /* se ejecuta cuando la aplicacion es instalada y cargada por primera vez */
        sqLiteDatabase.execSQL(tablaDepartamento);
        sqLiteDatabase.execSQL(tablaArea);

        for (int i = 0; i<tablaDepartamentoDatos.length; i++){
            sqLiteDatabase.execSQL(tablaDepartamentoDatos[i]);
        }

        for (int i = 0; i<tablaAreaDatos.length; i++){
            sqLiteDatabase.execSQL(tablaAreaDatos[i]);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
