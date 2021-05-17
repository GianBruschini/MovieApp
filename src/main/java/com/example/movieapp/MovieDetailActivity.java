package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView MovieThumbnailImg;
    private TextView titulo;
    private TextView descripcion;
    private TextView duracion;
    private RecyclerView rvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        String movieTitle = iniView();
        setUpRvCast(movieTitle);
        renderDetalle(movieTitle);
    }

    private void setUpRvCast(String movieTitle) {

        List<Cast>mData = new ArrayList<>();
        if(movieTitle.equals("Final score")){
            mData.add(new Cast("name",R.drawable.lara));
            mData.add(new Cast("name",R.drawable.pierce));
            mData.add(new Cast("name",R.drawable.dave));
            mData.add(new Cast("name",R.drawable.alex));
            mData.add(new Cast("name",R.drawable.ray));
        }

        if(movieTitle.equals("Una bala en la cabeza")){
            mData.add(new Cast("name",R.drawable.sylvester));
            mData.add(new Cast("name",R.drawable.jason));
            mData.add(new Cast("name",R.drawable.chris));
            mData.add(new Cast("name",R.drawable.sungkang));
            mData.add(new Cast("name",R.drawable.sarah));
        }

        if(movieTitle.equals("John Wick")){
            mData.add(new Cast("name",R.drawable.john));
            mData.add(new Cast("name",R.drawable.lance));
            mData.add(new Cast("name",R.drawable.lara));
            mData.add(new Cast("name",R.drawable.bridget));
            mData.add(new Cast("name",R.drawable.sarah));
        }

        if(movieTitle.equals("Rambo")){
            mData.add(new Cast("name",R.drawable.sylvester));
            mData.add(new Cast("name",R.drawable.lance));
            mData.add(new Cast("name",R.drawable.chris));
            mData.add(new Cast("name",R.drawable.bridget));
            mData.add(new Cast("name",R.drawable.ray));
        }

        castAdapter = new CastAdapter(this,mData);
        rvCast.setAdapter(castAdapter);
        rvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    private String iniView() {
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        MovieThumbnailImg= findViewById(R.id.detail_movie_img);
        MovieThumbnailImg.setImageResource(imageResourceId);
        titulo = findViewById(R.id.detail_titulo);
        descripcion = findViewById(R.id.detail_description);
        duracion = findViewById(R.id.detail_duracion);
        rvCast = findViewById(R.id.rvCast);
        return movieTitle;
    }

    private void renderDetalle(String movieTitle) {
        titulo.setText(movieTitle);
        if(movieTitle.equals("Una bala en la cabeza")){
            descripcion.setText("Después de la muerte de sus respectivos compañeros, un sicario de Nueva Orleans y un detective de Washington forman una alianza para acabar con su enemigo común.");
            duracion.setText("Duracion: 1h 37m");
        }
        if(movieTitle.equals("Final score")){
            descripcion.setText("Un exsoldado libra una guerra en solitario en contra de unos terroristas mortales que mantienen a su sobrina como rehén durante un partido de fútbol.");
            duracion.setText("Duracion: 1h 45m");
        }
        if(movieTitle.equals("John Wick")){
            descripcion.setText("John Wick, un exasesino a sueldo, se enfrenta al mafioso Viggo Tarazov, quien ofrece una recompensa a aquel que logre acabar con la vida de Wick.");
            duracion.setText("Duracion: 1h 42m");
        }
        if(movieTitle.equals("Rambo")){
            descripcion.setText("John Rambo vive tranquilo en un rancho en Arizona, pero cuando recibe la noticia de que una adolescente ha desaparecido tras haber cruzado la frontera a México para ir a una fiesta, decide ir en su búsqueda.");
            duracion.setText("Duracion: 1h 39m");
        }
    }

    public void compartirPelicula(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Compartiendo");
        i.putExtra(Intent.EXTRA_TEXT, descripcion.getText());
        startActivity(Intent.createChooser(i, "Enviar a"));
    }
}