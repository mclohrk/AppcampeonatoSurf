package com.mclohrk.appcampeonatosurf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    public Conexao(Context context){
        super(context, name, null,version);
    }

    private static final String name = "banco.db";
    private static final int version =1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table surfista(id integer primary key autoincrement,"
                + "nome varchar(50), paiz varchar(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
