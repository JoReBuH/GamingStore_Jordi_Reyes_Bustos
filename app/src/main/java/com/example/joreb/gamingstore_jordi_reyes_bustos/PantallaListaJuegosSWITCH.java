package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PantallaListaJuegosSWITCH extends AppCompatActivity {

    ListView listaJuegosSWITCH;

    //VARIABLE CON LOS DATOS DE LOS JUEGOS LISTADOS EN
    String[][] datosJuegosSWITCH = {
            {"The Legend of Zelda: Breath of the Wild","Nintendo +16","The Legend of Zelda: Breath of the Wild es un juego de ....","59,99","zw47_q9wbBE"},
            {"Xenoblade Chronicles 2","Monolith Soft +12","Xenoblade Chronicles 2 es un JRPG en....","59,99","DOQ9q4HDb0U"}

    };

    //VARIABLE CON LAS IMAGENES DE JUEGOS SWITCH
    int [] imagenesJuegosSWITCH={R.drawable.imagen_zelda_switch,R.drawable.imagen_xenoverse2_switch};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_lista_juegos_switch);

        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Instaciamos la vista SWITCH

        listaJuegosSWITCH = (ListView) findViewById(R.id.ListaJuegosSWITCH);
        listaJuegosSWITCH.setAdapter(new Adaptador(PantallaListaJuegosSWITCH.this,datosJuegosSWITCH,imagenesJuegosSWITCH));

        //PASAR DATOS A PANTALLA JUEGOS SWITCH
        listaJuegosSWITCH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Intent intentPantallaJuegoSWITCH = new Intent(view.getContext(),PantallaJuegoSWITCH.class);
                intentPantallaJuegoSWITCH.putExtra("imagen",imagenesJuegosSWITCH[posicion]);
                intentPantallaJuegoSWITCH.putExtra("tituloSWITCH",datosJuegosSWITCH[posicion][0]);
                intentPantallaJuegoSWITCH.putExtra("descripcionAmpliadaSWITCH",datosJuegosSWITCH[posicion][2]);
                intentPantallaJuegoSWITCH.putExtra("precioSWITCH",datosJuegosSWITCH[posicion][3]);
                intentPantallaJuegoSWITCH.putExtra("StringVideoYouTube",datosJuegosSWITCH[posicion][4]);
                startActivityForResult(intentPantallaJuegoSWITCH,3);
            }
        });


    }
}
