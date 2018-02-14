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

public class PantallaJuegoPC extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView YTPV;
    String claveYoutube="AIzaSyCaBvmSOgAED6OfZ7dEkL1Dea3UJJutPdo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego_pc);

        TextView tituloJuegoPC = (TextView) findViewById(R.id.tituloJuegoSelecionadoPC);
        ImageView imagenJuegoPC = (ImageView) findViewById(R.id.imagenJuegoSelecionadoPC);
        TextView precioJuegoPC = (TextView) findViewById(R.id.PrecioJuegoSelecionadoPC);
        TextView descripcionCompletaJuegoPC = (TextView) findViewById(R.id.DescripcionAmpliadaJuegoSelecionadoPC);
        //Parte Video YouTube.
        YTPV=(YouTubePlayerView)findViewById(R.id.VideoYoutubeJuegoPC);
        YTPV.initialize(claveYoutube,this);
        Intent intent = getIntent();
        tituloJuegoPC.setText(intent.getStringExtra("tituloPC"));
        imagenJuegoPC.setImageResource(intent.getIntExtra("imagen",R.drawable.imagen_pubg_pc));
        precioJuegoPC.setText(intent.getStringExtra("precioPC"));
        descripcionCompletaJuegoPC.setText(intent.getStringExtra("descripcionAmpliadaPC"));

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
