package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.ConcurrentModificationException;

public class duracionActivity extends AppCompatActivity {

    RadioButton treintamin;
    RadioButton treintaysesenta;
    RadioButton mayora60;
    RadioButton medaigual;
    String drama;
    String comedia;
    String terror;
    String accion;
    String aventura;
    String musicales;
    String suspenso;
    String cienciaFiccion;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duracion);
        treintamin = findViewById(R.id.treintamin);
        treintaysesenta= findViewById(R.id.treintaysesenta);
        mayora60=findViewById(R.id.mayora60);
        medaigual = findViewById(R.id.medaigual);

        vueltaAtrasCargarDatos();
        datosActivityMain();


    }

    public void comprobarTreinta(View view){
        if(treintamin.isChecked()){
            treintaysesenta.setChecked(false);
            mayora60.setChecked(false);
            medaigual.setChecked(false);
        }


    }

    public void comprobarTreintaSesenta(View view){
        if(treintaysesenta.isChecked()){
            treintamin.setChecked(false);
            mayora60.setChecked(false);
            medaigual.setChecked(false);
        }

    }

    public void comprobarMas60(View view){
        if(mayora60.isChecked()){
            treintamin.setChecked(false);
            treintaysesenta.setChecked(false);
            medaigual.setChecked(false);
        }

    }

    public void comprobarMedaigual(View view){

        if(medaigual.isChecked()){
            treintamin.setChecked(false);
            treintaysesenta.setChecked(false);
            mayora60.setChecked(false);
        }


    }

    public void vueltaAtrasCargarDatos(){

        int valor= getIntent().getIntExtra("valor",0);

        if(valor==1) {
            SharedPreferences prefs = getSharedPreferences("shared2", MODE_PRIVATE);
            String treinta = prefs.getString("treintamin", null);
            String tys = prefs.getString("treintaysesenta", null);
            String mas60 = prefs.getString("mayora60", null);
            String mdi = prefs.getString("medaigual", null);

            if (treinta != null) {
                treintamin.setChecked(true);
            }
            if (tys != null) {
                treintaysesenta.setChecked(true);
            }
            if (mas60 != null) {
                mayora60.setChecked(true);
            }
            if (mdi != null) {
                medaigual.setChecked(true);

            }
            SharedPreferences.Editor editor = getSharedPreferences("shared2", MODE_PRIVATE).edit();
            editor.clear();
            editor.commit();

        }
    }

    public void volverAtras(View view) {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("valor",1);
        this.finish();
        startActivity(i);
    }

    private void datosActivityMain() {
        i = new Intent(duracionActivity.this,preferenciasActivity.class);
        comedia=getIntent().getStringExtra("comedia");
        i.putExtra("comedia",comedia);
        drama=getIntent().getStringExtra("drama");
        i.putExtra("drama",drama);
        terror=getIntent().getStringExtra("terror");
        i.putExtra("terror",terror);
        accion=getIntent().getStringExtra("accion");
        i.putExtra("accion",terror);
        aventura=getIntent().getStringExtra("aventura");
        i.putExtra("aventura",aventura);
        musicales=getIntent().getStringExtra("musicales");
        i.putExtra("musicales",musicales);
        suspenso=getIntent().getStringExtra("suspenso");
        i.putExtra("suspenso",suspenso);
        cienciaFiccion=getIntent().getStringExtra("cienciaFiccion");
        i.putExtra("cienciaFiccion",cienciaFiccion);
    }


    public void continuar(View view) {
        checking();
        startActivity(i);
    }



    private void checking() {
        if(treintamin.isChecked()) {
            i.putExtra("treintamin",treintamin.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared2", MODE_PRIVATE).edit();
            editor.putString("treintamin",treintamin.getText().toString().trim() );
            editor.apply();

        }
        if(treintaysesenta.isChecked()) {
            i.putExtra("treintaysesenta",treintaysesenta.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared2", MODE_PRIVATE).edit();
            editor.putString("treintaysesenta",treintamin.getText().toString().trim() );
            editor.apply();

        }
        if(mayora60.isChecked()) {
            i.putExtra("mayora60",mayora60.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared2", MODE_PRIVATE).edit();
            editor.putString("mayora60",treintamin.getText().toString().trim() );
            editor.apply();

        }

        if(medaigual.isChecked()) {
            i.putExtra("medaigual",medaigual.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared2", MODE_PRIVATE).edit();
            editor.putString("medaigual",treintamin.getText().toString().trim() );
            editor.apply();

        }

    }
}