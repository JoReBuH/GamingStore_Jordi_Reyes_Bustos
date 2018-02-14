package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PantallaListaJuegosXBOX extends AppCompatActivity {

    /*VARIABLES*/
    ListView listaJuegosXBOX;

    //VARIABLE CON LOS DATOS DE LOS JUEGOS LISTADOS EN
    String[][] datosJuegosXBOX = {
            {"Forza Horizon 3","Playground Games +12","Forza Horizon 3 es un juego de condución....","49,99","rKvs9iDuRJA"},
            {"Gears Of War 4"," The Coalition +18","Gears Of War 4 es un shooter en....","29,99","SZJPInpaLRs"}

    };

    //VARIABLE CON LAS IMAGENES DE JUEGOS PS4
    int [] imagenesJuegosXBOX={R.drawable.imagen_forzahorizon3_xbox,R.drawable.imagen_gearsofwar4_xbox};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_lista_juegos_xbox);
        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Instaciamos la vista PS4

        listaJuegosXBOX = (ListView) findViewById(R.id.ListaJuegosXBOX);
        listaJuegosXBOX.setAdapter(new Adaptador(PantallaListaJuegosXBOX.this,datosJuegosXBOX,imagenesJuegosXBOX));

        //PASAR DATOS A PANTALLA JUEGOS XBOX
        listaJuegosXBOX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Intent intentPantallaJuegoXBOX = new Intent(view.getContext(),PantallaJuegoXBOX.class);
                intentPantallaJuegoXBOX.putExtra("imagen",imagenesJuegosXBOX[posicion]);
                intentPantallaJuegoXBOX.putExtra("tituloXBOX",datosJuegosXBOX[posicion][0]);
                intentPantallaJuegoXBOX.putExtra("descripcionAmpliadaXBOX",datosJuegosXBOX[posicion][2]);
                intentPantallaJuegoXBOX.putExtra("precioXBOX",datosJuegosXBOX[posicion][3]);
                intentPantallaJuegoXBOX.putExtra("StringVideoYouTube",datosJuegosXBOX[posicion][4]);
                startActivityForResult(intentPantallaJuegoXBOX,3);
            }
        });

    }
}
