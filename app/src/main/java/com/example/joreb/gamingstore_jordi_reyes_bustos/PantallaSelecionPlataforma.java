package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PantallaSelecionPlataforma extends AppCompatActivity {

    ImageButton btnPlataformaPS4,btnPlataformaXBOX,btnPlataformaPC,btnPlataformaSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_selecion_plataforma);

        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnPlataformaPS4 = (ImageButton) findViewById(R.id.btnImagenPlataformaPS4);
        btnPlataformaXBOX = (ImageButton) findViewById(R.id.btnImagenPlataformaXbox);
        btnPlataformaPC = (ImageButton) findViewById(R.id.btnImagenPlataformaPC);
        btnPlataformaSwitch = (ImageButton) findViewById(R.id.btnImagenPlataformaSwitch);

        //PANTALLA PS4
        btnPlataformaPS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPantallaSelecionPlataformaPS4 = new Intent(PantallaSelecionPlataforma.this,PantallaListaJuegosPS4.class);
                startActivityForResult(intentPantallaSelecionPlataformaPS4,0);
            }
        });
        //PANTALLA XBOX
        btnPlataformaXBOX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPantallaSelecionPlataformaXBOX = new Intent(PantallaSelecionPlataforma.this,PantallaListaJuegosXBOX.class);
                startActivityForResult(intentPantallaSelecionPlataformaXBOX,0);
            }
        });
        //PANTALLA PC
        btnPlataformaPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPantallaSelecionPlataformaPC = new Intent(PantallaSelecionPlataforma.this,PantallaListaJuegosPC.class);
                startActivityForResult(intentPantallaSelecionPlataformaPC,0);
            }
        });
        //PANTALLA SWITCH
        btnPlataformaSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPantallaSelecionPlataformaSWITCH = new Intent(PantallaSelecionPlataforma.this,PantallaListaJuegosSWITCH.class);
                startActivityForResult(intentPantallaSelecionPlataformaSWITCH,0);
            }
        });
    }
}
