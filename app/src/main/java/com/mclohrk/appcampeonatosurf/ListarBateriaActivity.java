package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListarBateriaActivity extends AppCompatActivity {

    public final static String LISTAR_BAT_ACTVTY = "ListarBateriaActivity";
    private ListView listview;
    private BateriaDAO bateriaDAO;
    private List<Bateria> baterias;
    private List<Bateria> bateriasFiltrado = new ArrayList<Bateria>();
    private SurfistaDAO surfistaDAO;
    private List<Surfista> surfistas;

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

    public void startActivity(String url) {
        Intent intent = new Intent(this, BateriaSurfistListActivity.class);
        // Adiconamos a url ao intent...
        intent.putExtra(LISTAR_BAT_ACTVTY, url);
        startActivity(intent);
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
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), baterias.get(position).getNome(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListarBateriaActivity.this,
                        BateriaSurfistListActivity.class);
                intent.putExtra("Nome", baterias.get((int)id).getNome());
                Toast.makeText(getBaseContext(), baterias.get((int) id).getNome(), Toast.LENGTH_SHORT).show();
                //surfistas =  surfistaDAO.listaSurfistas((int) id);
                startActivity(intent);

                //buscaBateriaId(position);

                /*
                abre lista de surfista
                pega id da bateria
                joga id no metodo buscarbateria
                busca surfista com id bateria
                retorna lista de surfistas
                retorna lista em view
                .2 click em surfista para add
                * */
            }
        });

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

    public void buscaBateriaId(Integer i) {


        for (Bateria bateria : baterias) {
            if (bateria.getId() == i) {
                bateriasFiltrado.add(bateria);
            }
        }
        listview.invalidateViews();

    }


}
