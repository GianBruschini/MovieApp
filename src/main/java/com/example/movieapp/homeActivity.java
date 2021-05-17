package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.movieapp.Interfaces.MovieApi;

import org.json.JSONObject;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {
    String peliculas;
    String series;
    String ambas;
    String treintamin;
    String treintaysesenta;
    String mayora60;
    String medaigual;
    String drama;
    String comedia;
    String terror;
    String accion;
    String aventura;
    String musicales;
    String suspenso;
    String cienciaFiccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        datosPreferenciasActivity();
        datosActivityMain();
        datosDuracionActivity();


    }


    private void datosDuracionActivity() {
        treintamin = getIntent().getStringExtra("treintamin");
        treintaysesenta = getIntent().getStringExtra("treintaysesenta");
        mayora60 = getIntent().getStringExtra("mayora60");
        medaigual = getIntent().getStringExtra("medaigual");
        System.out.println("ESSS" + " " + treintamin);
    }

    private void datosActivityMain() {
        comedia = getIntent().getStringExtra("comedia");
        drama = getIntent().getStringExtra("drama");
        terror = getIntent().getStringExtra("terror");
        accion = getIntent().getStringExtra("accion");
        aventura = getIntent().getStringExtra("aventura");
        musicales = getIntent().getStringExtra("musicales");
        suspenso = getIntent().getStringExtra("suspenso");
        cienciaFiccion = getIntent().getStringExtra("cienciaFiccion");
        System.out.println("ESSS" + " " + comedia);
    }

    private void datosPreferenciasActivity() {
        series = getIntent().getStringExtra("series");
        peliculas = getIntent().getStringExtra("peliculas");
        ambas = getIntent().getStringExtra("ambas");
        System.out.println("ESSS" + " " + series);
    }


    public void Accion1(View view) {
        Intent i = new Intent(this,detalleActivity.class);
        i.putExtra("primera","");
        startActivity(i);
    }
}







