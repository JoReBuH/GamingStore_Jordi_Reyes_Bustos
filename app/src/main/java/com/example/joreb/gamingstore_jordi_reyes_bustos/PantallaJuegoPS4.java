package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PantallaJuegoPS4 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    /*VARIABLES VIDEO YOUTUBE*/
    YouTubePlayerView YTPV;
    String claveYoutube="AIzaSyCaBvmSOgAED6OfZ7dEkL1Dea3UJJutPdo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego_ps4);

        TextView tituloJuegoPS4 = (TextView) findViewById(R.id.tituloJuegoSelecionadoPS4);
        ImageView imagenJuegoPS4 = (ImageView) findViewById(R.id.imagenJuegoSelecionadoPS4);
        TextView precioJuegoPS4 = (TextView) findViewById(R.id.PrecioJuegoSelecionadoPS4);
        TextView descripcionCompletaJuegoPS4 = (TextView) findViewById(R.id.DescripcionAmpliadaJuegoSelecionadoPS4);
        //Parte Video YouTube.
        YTPV=(YouTubePlayerView)findViewById(R.id.VideoYoutubeJuegoPS4);
        YTPV.initialize(claveYoutube,this);
        Intent intent = getIntent();
        tituloJuegoPS4.setText(intent.getStringExtra("tituloPS4"));
        imagenJuegoPS4.setImageResource(intent.getIntExtra("imagen",R.drawable.imagen_galeria_call_of_duty));
        precioJuegoPS4.setText(intent.getStringExtra("precioPS4"));
        descripcionCompletaJuegoPS4.setText(intent.getStringExtra("descripcionAmpliadaPS4"));


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Intent intent = getIntent();
        youTubePlayer.cueVideo(intent.getStringExtra("StringVideoYouTube"));
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
