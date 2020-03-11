package com.mclohrk.appcampeonatosurf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;
    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table surfista(id integer primary key autoincrement,"
                + "nome varchar(50), paiz varchar(50))");

       // db.execSQL("create table bateria(id integer primary key autoincrement," + "nome varchar(50)," +
              //  " id_surfista integer, foreign key(id_surfista) references surfista(id)  ON UPDATE SET NULL)");

         db.execSQL("create table bateria(id integer primary key autoincrement," + "nome varchar(50)," +
                 "surfista varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
