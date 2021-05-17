package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox dramaCheck;
    CheckBox comediaCheck;
    CheckBox terrorCheck;
    CheckBox accionCheck;
    CheckBox aventuraCheck;
    CheckBox musicalesCheck;
    CheckBox suspensoCheck;
    CheckBox cienciaFiccionCheck;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dramaCheck = findViewById(R.id.drama);
        comediaCheck = findViewById(R.id.comedia);
        terrorCheck = findViewById(R.id.terror);
        accionCheck = findViewById(R.id.accion);
        aventuraCheck = findViewById(R.id.aventura);
        musicalesCheck = findViewById(R.id.musicales);
        suspensoCheck = findViewById(R.id.suspenso);
        cienciaFiccionCheck = findViewById(R.id.cienciaFiccion);
        vueltaAtrasCargarDatos();

    }


    public void vueltaAtrasCargarDatos(){

        int valor= getIntent().getIntExtra("valor",0);

        if(valor==1){
            SharedPreferences prefs = getSharedPreferences("shared", MODE_PRIVATE);
            String drama= prefs.getString("drama", null);
            String comedia= prefs.getString("comedia", null);
            String terror= prefs.getString("terror", null);
            String accion= prefs.getString("accion", null);
            String aventura= prefs.getString("aventura", null);
            String musicales= prefs.getString("musicales", null);
            String suspenso= prefs.getString("suspenso", null);
            String cienciaFiccion= prefs.getString("cienciaFiccion", null);
            System.out.println("ESS" + " " + drama);
            System.out.println("ESS" + " " + comedia);
            System.out.println("ESS" + " " + terror);
            System.out.println("ESS" + " " + accion);
            System.out.println("ESS" + " " + aventura);

            if(drama!=null){
                dramaCheck.setChecked(true);
            }
            if(comedia!=null){
                comediaCheck.setChecked(true);
            }
            if(terror!=null){
                terrorCheck.setChecked(true);
            }
            if(accion!=null){
                accionCheck.setChecked(true);
            }
            if(aventura!=null){
                aventuraCheck.setChecked(true);
            }
            if(musicales!=null){
                musicalesCheck.setChecked(true);
            }
            if(suspenso!=null){
                suspensoCheck.setChecked(true);
            }
            if(cienciaFiccion!=null){
                cienciaFiccionCheck.setChecked(true);
            }
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.clear();
            editor.commit();

        }
    }


    public void continuar(View view) {
        i = new Intent(MainActivity.this,duracionActivity.class);
        checking();
        startActivity(i);



    }

    private void checking() {
        if(dramaCheck.isChecked()) {
            i.putExtra("drama",dramaCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("drama",dramaCheck.getText().toString().trim() );
            editor.apply();

        }
        if(comediaCheck.isChecked()) {
            i.putExtra("comedia",comediaCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("comedia",comediaCheck.getText().toString().trim() );
            editor.apply();

        }
        if(terrorCheck.isChecked()) {
            i.putExtra("terror",terrorCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("terror",terrorCheck.getText().toString().trim() );
            editor.apply();

        }

        if(accionCheck.isChecked()) {
            i.putExtra("accion",accionCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("accion",accionCheck.getText().toString().trim() );
            editor.apply();

        }

        if(aventuraCheck.isChecked()) {
            i.putExtra("aventura",aventuraCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("aventura",aventuraCheck.getText().toString().trim() );
            editor.apply();

        }

        if(musicalesCheck.isChecked()) {
            i.putExtra("musicales",musicalesCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("musicales",musicalesCheck.getText().toString().trim() );
            editor.apply();

        }


        if(suspensoCheck.isChecked()) {
            i.putExtra("suspenso",suspensoCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("suspenso",suspensoCheck.getText().toString().trim() );
            editor.apply();

        }

        if(cienciaFiccionCheck.isChecked()) {
            i.putExtra("cienciaFiccion",cienciaFiccionCheck.getText().toString().trim());
            SharedPreferences.Editor editor = getSharedPreferences("shared", MODE_PRIVATE).edit();
            editor.putString("cienciaFiccion",cienciaFiccionCheck.getText().toString().trim() );
            editor.apply();

        }
    }



}