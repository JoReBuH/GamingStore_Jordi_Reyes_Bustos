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

public class PantallaJuegoXBOX extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    YouTubePlayerView YTPV;
    String claveYoutube="AIzaSyCaBvmSOgAED6OfZ7dEkL1Dea3UJJutPdo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego_xbox);

        TextView tituloJuegoXBOX = (TextView) findViewById(R.id.tituloJuegoSelecionadoXBOX);
        ImageView imagenJuegoXBOX = (ImageView) findViewById(R.id.imagenJuegoSelecionadoXBOX);
        TextView precioJuegoXBOX = (TextView) findViewById(R.id.PrecioJuegoSelecionadoXBOX);
        TextView descripcionCompletaJuegoXBOX = (TextView) findViewById(R.id.DescripcionAmpliadaJuegoSelecionadoXBOX);
        //Parte Video YouTube.
        YTPV=(YouTubePlayerView)findViewById(R.id.VideoYoutubeJuegoXBOX);
        YTPV.initialize(claveYoutube,this);
        Intent intent = getIntent();
        tituloJuegoXBOX.setText(intent.getStringExtra("tituloXBOX"));
        imagenJuegoXBOX.setImageResource(intent.getIntExtra("imagen",R.drawable.imagen_forzahorizon3_xbox));
        precioJuegoXBOX.setText(intent.getStringExtra("precioXBOX"));
        descripcionCompletaJuegoXBOX.setText(intent.getStringExtra("descripcionAmpliadaXBOX"));
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
