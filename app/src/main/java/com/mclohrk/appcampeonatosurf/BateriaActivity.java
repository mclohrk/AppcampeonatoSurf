package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BateriaActivity extends AppCompatActivity {

    private EditText nomeBat;
    private EditText nomeSurfista;
    private BateriaDAO bateriaDAO;
    private ListView listview;

   // private SurfistaDAO surfistaDAO;
    private List<Bateria> baterias;
    private List<Bateria> BateriasFiltrado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listview = findViewById(R.id.listaBaterias);
        setContentView(R.layout.activity_cad_bateria_);
        nomeSurfista = findViewById(R.id.editTextSufista);
        nomeBat = findViewById(R.id.editTextNomeBat);
        bateriaDAO = new BateriaDAO(this);
    }

    //listarbateria
    public void salvarBateria(View view) {
        Bateria bateria = new Bateria();
        bateria.setNome(nomeBat.getText().toString());
        bateria.setSurfista(nomeSurfista.getText().toString());
        bateriaDAO.inserirBateria(bateria);
        long id = bateriaDAO.inserirBateria(bateria);
        Toast.makeText(this, "Bateria Criada com  sucesso  " + id, Toast.LENGTH_SHORT).show();
    }

}
