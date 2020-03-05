package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.AndroidException;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listar_Surfista_Activity extends AppCompatActivity {

    private ListView listview;
    private SurfistaDAO surfistaDAO;
    private List<Surfista> surfistas;
    private List<Surfista> SurfistasFiltrado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__surfista_);

        listview = findViewById(R.id.listarSurfistas);
        surfistaDAO = new SurfistaDAO(this);
        surfistas = surfistaDAO.listaSurfistas();
        SurfistasFiltrado.addAll(surfistas);
        ArrayAdapter<Surfista> adapter = new ArrayAdapter<Surfista>(this, android.R.layout.simple_list_item_1,surfistas);
        listview.setAdapter(adapter);


    }
}
