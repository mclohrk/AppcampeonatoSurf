package com.mclohrk.appcampeonatosurf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SurfistaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;


    public SurfistaDAO(Context context) {

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }

    public long inserirSurfista(Surfista surfista) {

        ContentValues values = new ContentValues();
        values.put("nome", surfista.getNome());
        values.put("paiz", surfista.getPaiz());
        return banco.insert("surfista", null, values);

    }

    public List<Surfista> listaSurfistas() {
        List<Surfista> surfistas = new ArrayList<>();
        Cursor cursor = banco.query("surfista", new String[]{"id", "nome", "paiz"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Surfista surfista = new Surfista();
            surfista.setId(cursor.getInt(0));
            surfista.setNome(cursor.getString(1));
            surfista.setPaiz(cursor.getString(2));
            surfistas.add(surfista);
        }
        return surfistas;
    }

    public void excluirSurfista(Surfista surfista) {
        banco.delete("surfista", "id = ?", new String[]{surfista.getId().toString()});

    }
}

