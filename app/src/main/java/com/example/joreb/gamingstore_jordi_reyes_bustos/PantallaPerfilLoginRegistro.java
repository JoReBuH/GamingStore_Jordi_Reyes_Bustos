package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaPerfilLoginRegistro extends AppCompatActivity {

    /*VARIABLES*/
    public Button btnPantallaLogin,btnPantallaRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_perfil_login_registro);

        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Metodo con el cual pasamos a la pantalla de Login.
        btnPantallaLogin =(Button) findViewById(R.id.BtnIniciaSesion);
        btnPantallaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPantallaLogin = new Intent(PantallaPerfilLoginRegistro.this,PantallaLogin.class);
                startActivityForResult(intentPantallaLogin,1);
            }
        });

        //Metodo con el cual pasamos a la pantalla de Registro.
        btnPantallaRegistro = (Button) findViewById(R.id.BtnRegistro);
        btnPantallaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPantallaRegistro = new Intent(PantallaPerfilLoginRegistro.this,PantallaRegistro.class);
                startActivityForResult(intentPantallaRegistro,2);
            }
        });
    }
}
