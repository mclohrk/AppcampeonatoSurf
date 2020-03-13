package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.os.Bundle;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.List;

public class BateriaSurfistListActivity extends AppCompatActivity {

    private ListView listview;
    private BateriaDAO bateriaDAO;
    private List<Bateria> baterias;
    private List<Bateria> bateriasFiltrado = new ArrayList<Bateria>();
    private SurfistaDAO surfistaDAO;
    private List<Surfista> surfistas;
    private List<Surfista> SurfistasFiltrado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bateria_surfist_list);
        Intent intent = getIntent();
        String parametro = (String) intent.getSerializableExtra("Nome");
        TextView nome = findViewById(R.id.textView2);
        nome.setText(parametro);
        Intent intent2 = getIntent();
        String url = intent2.getStringExtra(ListarBateriaActivity.LISTAR_BAT_ACTVTY);
        ////WebView webView = findViewById(R.id.listaSurfistaBateria);
        ////webView.loadUrl(url);

        listview = findViewById(R.id.listaSurfistaBateria);
        surfistaDAO = new SurfistaDAO(this);
        surfistas = surfistaDAO.listaSurfistas();
        SurfistasFiltrado.addAll(surfistas);
        ArrayAdapter<Surfista> adapter = new ArrayAdapter<Surfista>(this, android.R.layout.simple_list_item_1, SurfistasFiltrado);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);

    }
}
