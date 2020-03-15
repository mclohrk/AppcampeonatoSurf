package com.mclohrk.appcampeonatosurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button btnTelaSurfista = findViewById(R.id.btnSurfista);
        btnTelaSurfista.setOnClickListener(this);
        Button btnTelaBateria = findViewById(R.id.btnBateriasav);
        btnTelaBateria.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSurfista:
                Intent intentSurfist = new Intent(this, ListarSurfistaActivity.class);
                startActivity(intentSurfist);
                break;
            case R.id.btnBateriasav:
                Intent intentBat = new Intent(this,ListarBateriaActivity.class);
                startActivity(intentBat);
                break;
        }


    }

}
