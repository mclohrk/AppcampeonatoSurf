package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.AndroidException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

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
        ArrayAdapter<Surfista> adapter = new ArrayAdapter<Surfista>(this, android.R.layout.simple_list_item_1, SurfistasFiltrado);
        listview.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                buscaSurfistaPaiz(newText);
                return false;
            }
        });
        return true;
    }
    public void buscaSurfistaPaiz(String str){
        SurfistasFiltrado.clear();
        for(Surfista surfista : surfistas){
            if(surfista.getPaiz().toLowerCase().contains(str.toLowerCase())){
                SurfistasFiltrado.add(surfista);
            }
        }
        listview.invalidateViews();
    }

    public void cadastrar(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        surfistas = surfistaDAO.listaSurfistas();
        SurfistasFiltrado.clear();
        SurfistasFiltrado.addAll(surfistas);
        listview.invalidate();
    }

}
