package com.mclohrk.appcampeonatosurf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;

public class BateriaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public BateriaDAO(Context context) {

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }


    public long inserirBateria(Bateria bateria) {

        ContentValues values = new ContentValues();
        values.put("nome", bateria.getNome());
        values.put("nomeSurfista", bateria.getSurfista());
        return banco.insert("bateria", null, values);
    }

/*
    public long addSurfistaBateria(Surfista surfista) {

        SurfistaDAO surfistaDAO = new SurfistaDAO();
        surfistaDAO.inserirSurfista(surfista);

        ContentValues values = new ContentValues();

        values.put("surfista", surfista.getId());
        values.put("paiz", surfista.getPaiz());
        values.put("nome", surfista.getNome());
        // Bateria bateria=new Bateria();
        //bateria.
        return banco.insert("surfista", null, values);
    }
*/

    public List<Bateria> listaBateria() {

        List<Bateria> baterias = new ArrayList<>();
        Cursor cursor = banco.query("bateria", new String[]{"id", "nome", "nomeSurfista"}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Bateria bateria = new Bateria();
            bateria.setId(cursor.getInt(0));
            bateria.setNome(cursor.getString(1));
            bateria.setSurfista(cursor.getString(2));
            baterias.add(bateria);
        }
        return baterias;
    }

    public void excluirBateria(Bateria bateria) {
        banco.delete("bateria", "id =?", new String[]{bateria.getId().toString()});

    }
}
