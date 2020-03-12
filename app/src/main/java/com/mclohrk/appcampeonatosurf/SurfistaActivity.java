package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SurfistaActivity extends AppCompatActivity {
    private EditText nome;
    private EditText paiz;
    private SurfistaDAO surfistaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfista);
        nome = findViewById(R.id.editTextNome);
        paiz = findViewById(R.id.editTextPaiz);
        surfistaDAO = new SurfistaDAO(this);
    }

    public void Salvar(View view) {
        Surfista surfista = new Surfista();
        surfista.setNome(nome.getText().toString());
        surfista.setPaiz(paiz.getText().toString());
        surfistaDAO.inserirSurfista(surfista);
        long id = surfistaDAO.inserirSurfista(surfista);
        Toast.makeText(this, "Surfista inserido com  sucesso  ", Toast.LENGTH_SHORT).show();
    }
}
