package com.example.joreb.gamingstore_jordi_reyes_bustos;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class PantallaRegistro extends AppCompatActivity {

    /*VARIABLES spinner*/

    Spinner spinnerPaises;
    String[] arrayPaises;

    /*VARIABLES DatePicker*/
    private static final String TAG = "PantallaRegistro";
    TextView displayDate;
    DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        //Linea que sirve para implemetar el retroceso entre activitis.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    /*SPINNER*/
        spinnerPaises = (Spinner) findViewById(R.id.SpinnerPaisPantallaRegistro);

        //Llamamos a Resources para extraer los datos de los values que tennemos en el array_spinner.xml y colocarlos en
        //la variable de arrayPaises
        arrayPaises=getResources().getStringArray(R.array.spinnerPaises);
        //Hacemos el adapter.
        ArrayAdapter<String> adapterPaises = new ArrayAdapter<String>(PantallaRegistro.this,android.R.layout.simple_spinner_item,arrayPaises);
        spinnerPaises.setAdapter(adapterPaises);

        /*DATEPICKER*/

        displayDate =(TextView) findViewById(R.id.textoActivacionDatePickerPantallaRegistro);
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el calendario
                Calendar calendario =Calendar.getInstance();
                int año = calendario.get(Calendar.YEAR);
                int dia = calendario.get(Calendar.DAY_OF_MONTH);
                int mes = calendario.get(Calendar.MONTH);

                DatePickerDialog dialog = new DatePickerDialog(PantallaRegistro.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateSetListener,año,dia,mes);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int dia, int mes, int año) {
                mes = mes+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy: "+ dia + "/" + mes + "/" + año );
                String fecha = dia + "/" + mes + "/" + año;
                displayDate.setText(fecha);
            }

        };

    }
}
