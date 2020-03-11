package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListarBateriaActivity extends AppCompatActivity {

    private ListView listview;
    private BateriaDAO bateriaDAO;
    private List<Bateria> baterias;
    private List<Bateria> bateriasFiltrado = new ArrayList<Bateria>();
    //private SurfistaDAO surfistaDAO;
    //private List<Surfista> surfistas;
    //private List<Surfista> SurfistasFiltrado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_bateria);
        listview = findViewById(R.id.listaBaterias);
        bateriaDAO = new BateriaDAO(this);
        baterias = bateriaDAO.listaBateria();
        bateriasFiltrado.addAll(baterias);
        ArrayAdapter<Bateria> adapter = new ArrayAdapter<Bateria>(this, android.R.layout.simple_list_item_1, bateriasFiltrado);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
    }


    @Override
    public void onResume() {
        super.onResume();
        baterias = bateriaDAO.listaBateria();
        bateriasFiltrado.clear();
        bateriasFiltrado.addAll(baterias);
        listview.invalidate();
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contexto_bateria, menu);

    }

    public void cadastrarBat(MenuItem item) {
        Intent intent = new Intent(this, BateriaActivity.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bateria, menu);
        return true;
    }

    public void buscaBateria(String str) {
        bateriasFiltrado.clear();
        for (Bateria bateria : baterias) {
            if (bateria.getNome().toLowerCase().contains(str.toLowerCase())) {
                bateriasFiltrado.add(bateria);
            }
        }
        listview.invalidateViews();

    }


}
