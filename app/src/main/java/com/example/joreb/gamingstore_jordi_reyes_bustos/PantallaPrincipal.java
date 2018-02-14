package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaPrincipal extends AppCompatActivity implements View.OnClickListener {

    /*VARIABLES*/

    Button btnAnteriorPantallaPrincipal,btnSiguientePantallaPrincipal;
    TextView textoJuegosPantallaPrincipal;
    ImageView galeriaPantallaPrincipal;

    /*Arrays con las diferentes imagenes de la galeria*/

    int[] arrayFotosGaleriaPantallaPrincipal={
        R.drawable.imagen_galeria_call_of_duty,
        R.drawable.imagen_galeria_destiny_2
    };

    /*Arrays con las diferentes nombres de las imagenes de la galeria*/
    String[] arrayNombresImagenesGaleria={
        "Call Of Duty WW2","Destiny 2"
    };

    /*Variable con el numero total de fotos en la galeria*/

    int numeroTotalFotosGaleria;
    int contador = 0;

    /*Varibles para la navigationBar*/

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        //PARTE PARA LA NAVIGATIONBAR

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigation_view = (NavigationView) findViewById(R.id.NavigationBar);

        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                //Aqui programamos las diferentes fincionalidades a realizar dependiendo del item selecionado.

                if (id == R.id.menuPerfil){
                    //Realizamos el intent para que nos lleve a la pantalla del registro y el login.
                    Intent intentPantallaLoginRegistro = new Intent(PantallaPrincipal.this,PantallaPerfilLoginRegistro.class);
                    startActivityForResult(intentPantallaLoginRegistro,0);
                }
                else if (id == R.id.menuVideojuegos){
                    //Realizamos el intent para que nos lleve a la pantallaSelecionPlataforma.
                    Intent intentPantallaSelecionPlataforma = new Intent(PantallaPrincipal.this,PantallaSelecionPlataforma.class);
                    startActivityForResult(intentPantallaSelecionPlataforma,1);
                    //Toast.makeText(PantallaPrincipal.this,"Texto2",Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.menuCesta){
                    Toast.makeText(PantallaPrincipal.this,"Texto3",Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.menuCalendario){
                    Toast.makeText(PantallaPrincipal.this,"Texto4",Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });


        //PARTE PARA LA GALERIA DE IMAGENES
        btnAnteriorPantallaPrincipal = (Button) findViewById(R.id.BtnAnteriorPantallaPrincipal);
        btnSiguientePantallaPrincipal = (Button) findViewById(R.id.BtnSiguientePantallaPrincipal);
        textoJuegosPantallaPrincipal = (TextView) findViewById(R.id.TextoJuegosPantallaPrincipal);
        galeriaPantallaPrincipal = (ImageView) findViewById(R.id.galeriaImagenesPantallaPrincipal);

        btnSiguientePantallaPrincipal.setOnClickListener(this);
        btnAnteriorPantallaPrincipal.setOnClickListener(this);

        //Ponemos la variable numeroTotalFotosGaleria a el numero de fotos que tenemos.

        numeroTotalFotosGaleria = arrayFotosGaleriaPantallaPrincipal.length;




    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //Implementacion del btnSiguiente
        if (id == R.id.BtnSiguientePantallaPrincipal){
            contador++;
            if (contador == numeroTotalFotosGaleria){
                contador=0;
            }
        }
        //Implementacion del btnAnterior
        if (id == R.id.BtnAnteriorPantallaPrincipal){
            contador--;
            if(contador==-1){
                contador=numeroTotalFotosGaleria-1;
            }
        }
        //Colocamos la imagen y el nombre correspondiente a ella.
        galeriaPantallaPrincipal.setImageResource(arrayFotosGaleriaPantallaPrincipal[contador]);
        textoJuegosPantallaPrincipal.setText(arrayNombresImagenesGaleria[contador]);

    }
    //METODO PARA EL CLICK DE LA NAVIGATION BAR

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
