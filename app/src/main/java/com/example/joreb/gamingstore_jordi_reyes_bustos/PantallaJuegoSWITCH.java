package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PantallaJuegoSWITCH extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    /*VARIABLES VIDEO YOUTUBE*/
    YouTubePlayerView YTPV;
    String claveYoutube="AIzaSyCaBvmSOgAED6OfZ7dEkL1Dea3UJJutPdo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego_switch);

        TextView tituloJuegoSWITCH = (TextView) findViewById(R.id.tituloJuegoSelecionadoSWITCH);
        ImageView imagenJuegoSWITCH = (ImageView) findViewById(R.id.imagenJuegoSelecionadoSWITCH);
        TextView precioJuegoSWITCH = (TextView) findViewById(R.id.PrecioJuegoSelecionadoSWITCH);
        TextView descripcionCompletaJuegoSWITCH = (TextView) findViewById(R.id.DescripcionAmpliadaJuegoSelecionadoSWITCH);
        //Parte Video YouTube.
        YTPV=(YouTubePlayerView)findViewById(R.id.VideoYoutubeJuegoSWITCH);
        YTPV.initialize(claveYoutube,this);
        Intent intent = getIntent();
        tituloJuegoSWITCH.setText(intent.getStringExtra("tituloSWITCH"));
        imagenJuegoSWITCH.setImageResource(intent.getIntExtra("imagen",R.drawable.imagen_zelda_switch));
        precioJuegoSWITCH.setText(intent.getStringExtra("precioSWITCH"));
        descripcionCompletaJuegoSWITCH.setText(intent.getStringExtra("descripcionAmpliadaSWITCH"));
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
