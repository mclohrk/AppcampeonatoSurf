package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BateriaSurfistListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bateria_surfist_list);
        Intent intent = getIntent();
        String parametro = (String) intent.getSerializableExtra("Nome");
        TextView nome =  findViewById(R.id.textView2);
        nome.setText(parametro);
    }
}
