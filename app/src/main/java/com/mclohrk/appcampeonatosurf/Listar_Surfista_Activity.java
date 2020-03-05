package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.AndroidException;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        registerForContextMenu(listview);
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
                buscaSurfista(newText);
                return false;
            }
        });
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contexto, menu);

    }

    public void buscaSurfista(String str) {
        SurfistasFiltrado.clear();
        for (Surfista surfista : surfistas) {
            if (surfista.getPaiz().toLowerCase().contains(str.toLowerCase())) {
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

    public void excl(MenuItem mItem) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) mItem.getMenuInfo();
        final Surfista exclSurfista = SurfistasFiltrado.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Atencion =/").setMessage("vou excluir o cara,  viu?")
                .setNegativeButton("NO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SurfistasFiltrado.remove(exclSurfista);
                        surfistas.remove(exclSurfista);
                        surfistaDAO.excluirSurfista(exclSurfista);
                        listview.invalidateViews();
                    }
                }).create();
        dialog.show();

    }


}
