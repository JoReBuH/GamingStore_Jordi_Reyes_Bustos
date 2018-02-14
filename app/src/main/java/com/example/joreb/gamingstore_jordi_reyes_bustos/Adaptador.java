package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JoReB on 28/01/2018.
 */

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context context;
    String [][] datosJuegosGeneral;
    int [] ImagenesGenral;

    public Adaptador(Context context, String[][] datosJuegosGeneral, int[] imagenesGenral) {
        this.context = context;
        this.datosJuegosGeneral = datosJuegosGeneral;
        this.ImagenesGenral = imagenesGenral;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        //Devolvemos la cantidad de imagenes que tenemos en la matriz.
        return ImagenesGenral.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Inicializamos el XML de los items.
        final View vista = inflater.inflate(R.layout.item_listview_ps4,null);
        TextView tituloVideojuego = (TextView) vista.findViewById(R.id.ItemTitulo);
        TextView descripcionCortaVideojuego = (TextView) vista.findViewById(R.id.ItemDescripcion);
        ImageView imagenVideojuego = (ImageView) vista.findViewById(R.id.ImagenItemPS4);

        //Rellenamos los campos con nuestra matriz.
        tituloVideojuego.setText(datosJuegosGeneral[i][0]);
        descripcionCortaVideojuego.setText(datosJuegosGeneral[i][1]);

        //Rellenar imagen
        imagenVideojuego.setImageResource(ImagenesGenral[i]);
        imagenVideojuego.setTag(i);

        return vista;
    }
}
