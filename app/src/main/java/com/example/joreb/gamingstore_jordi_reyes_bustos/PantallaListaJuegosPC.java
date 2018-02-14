package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PantallaListaJuegosPC extends AppCompatActivity {

    /*VARIABLES*/
    ListView listaJuegosPC;

    //VARIABLE CON LOS DATOS DE LOS JUEGOS LISTADOS EN
    String[][] datosJuegosPC = {
            {"PlayerUnknown's Battlegrounds","Bluehole Studio +18","PlayerUnknown's Battlegrounds es un shooter en....","29,99","fDLAFIhfFy4"},
            {"Warhammer II","The Creative Assembly +16","Warhammer II es un juego de estrategia....","30,99","hGWKRuDBB0s"}

    };

    //VARIABLE CON LAS IMAGENES DE JUEGOS PC
    int [] imagenesJuegosPC={R.drawable.imagen_pubg_pc,R.drawable.imagen_warhammer2_pc};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_lista_juegos_pc);

        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Instaciamos la vista PS4

        listaJuegosPC = (ListView) findViewById(R.id.ListaJuegosPC);
        listaJuegosPC.setAdapter(new Adaptador(PantallaListaJuegosPC.this,datosJuegosPC,imagenesJuegosPC));

        //PASAR DATOS A PANTALLA JUEGOS PC
        listaJuegosPC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Intent intentPantallaJuegoPC = new Intent(view.getContext(),PantallaJuegoPC.class);
                intentPantallaJuegoPC.putExtra("imagen",imagenesJuegosPC[posicion]);
                intentPantallaJuegoPC.putExtra("tituloPC",datosJuegosPC[posicion][0]);
                intentPantallaJuegoPC.putExtra("descripcionAmpliadaPC",datosJuegosPC[posicion][2]);
                intentPantallaJuegoPC.putExtra("precioPC",datosJuegosPC[posicion][3]);
                intentPantallaJuegoPC.putExtra("StringVideoYouTube",datosJuegosPC[posicion][4]);
                startActivityForResult(intentPantallaJuegoPC,3);
            }
        });


    }
}
