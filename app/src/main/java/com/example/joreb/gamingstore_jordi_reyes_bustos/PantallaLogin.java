package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PantallaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);

        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
