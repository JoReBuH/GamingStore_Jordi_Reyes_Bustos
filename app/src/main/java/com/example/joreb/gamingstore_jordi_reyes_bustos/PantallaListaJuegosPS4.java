package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PantallaListaJuegosPS4 extends AppCompatActivity {
    /*VARIABLES*/
    ListView listaJuegosPS4;

    //VARIABLE CON LOS DATOS DE LOS JUEGOS LISTADOS EN
    String[][] datosJuegosPS4 = {
            {"Call Of Duty MW2","Activision +18","Call of Duty es un shooter en....","69,99","wrf3kArb3qU"},
            {"Destiny 2","Activision +16","Destiny 2 es un shooter en....","40,99","78rj5zVb8pQ"}

    };

    //VARIABLE CON LAS IMAGENES DE JUEGOS PS4
    int [] imagenesJuegosPS4={R.drawable.imagen_galeria_call_of_duty,R.drawable.imagen_galeria_destiny_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_lista_juegos_ps4);

        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Instaciamos la vista PS4

        listaJuegosPS4 = (ListView) findViewById(R.id.ListaJuegosPS4);
        listaJuegosPS4.setAdapter(new Adaptador(PantallaListaJuegosPS4.this,datosJuegosPS4,imagenesJuegosPS4));

        //PASAR DATOS A PANTALLA JUEGOS PS4
        listaJuegosPS4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Intent intentPantallaJuegoPS4 = new Intent(view.getContext(),PantallaJuegoPS4.class);
                intentPantallaJuegoPS4.putExtra("imagen",imagenesJuegosPS4[posicion]);
                intentPantallaJuegoPS4.putExtra("tituloPS4",datosJuegosPS4[posicion][0]);
                intentPantallaJuegoPS4.putExtra("descripcionAmpliadaPS4",datosJuegosPS4[posicion][2]);
                intentPantallaJuegoPS4.putExtra("precioPS4",datosJuegosPS4[posicion][3]);
                intentPantallaJuegoPS4.putExtra("StringVideoYouTube",datosJuegosPS4[posicion][4]);
                startActivityForResult(intentPantallaJuegoPS4,3);
            }
        });

    }
}
