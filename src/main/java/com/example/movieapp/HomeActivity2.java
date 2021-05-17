package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActivityOptions;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity2 extends AppCompatActivity implements MovieitemClickListener {
    private List<Slide> lstSlides;
    private ViewPager sliderPager2;
    private TabLayout indicator;
    private RecyclerView MoviesRV;
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
    TextView etiqueta1;
    TextView etiqueta2;
    TextView etiqueta3;
    private final static int NOTIFICACION_ID = 0;
    private final static String CHANNEL_ID = "NOTIFICACION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        datosPreferenciasActivity();
        datosActivityMain();
        datosDuracionActivity();

        etiqueta1 = findViewById(R.id.etiqueta1);
        etiqueta2=findViewById(R.id.etiqueta2);
        etiqueta3=findViewById(R.id.etiqueta3);
        etiqueta1.setText("Accion");
        etiqueta2.setText("Superior a 60 minutos");
        etiqueta3.setText("Peliculas");


        sliderPager2=   findViewById(R.id.sliderPager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movie);


        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.accion1,null));
        lstSlides.add(new Slide(R.drawable.accion2,null));
        lstSlides.add(new Slide(R.drawable.accion3,null));
        lstSlides.add(new Slide(R.drawable.accion4,null));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderPager2.setAdapter(adapter);
        indicator.setupWithViewPager(sliderPager2,true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity2.sliderTimer(),4000,6000);


        List<Movie>lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Una bala en la cabeza",R.drawable.accion1));
        lstMovies.add(new Movie("Final score",R.drawable.accion2));
        lstMovies.add(new Movie("John Wick",R.drawable.accion3));
        lstMovies.add(new Movie("Rambo",R.drawable.accion4));


        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        createNotificationChannel();
        desplegarNotificacion();



    }

            private void datosDuracionActivity() {
                treintamin = getIntent().getStringExtra("treintamin");
                treintaysesenta = getIntent().getStringExtra("treintaysesenta");
                mayora60 = getIntent().getStringExtra("mayora60");
                medaigual = getIntent().getStringExtra("medaigual");
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

            }

            private void datosPreferenciasActivity() {
                series = getIntent().getStringExtra("series");
                peliculas = getIntent().getStringExtra("peliculas");
                ambas = getIntent().getStringExtra("ambas");
                System.out.println("ESSS" + " " + series);
            }

            @Override
            public void onMovieClick(Movie movie, ImageView movieImageView) {

                Intent intent = new Intent(this,MovieDetailActivity.class);
                intent.putExtra("title",movie.getTitle());
                intent.putExtra("imgURL",movie.getThumbnail());

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity2.this,movieImageView,"sharedName");
                startActivity(intent,options.toBundle());



            }

            class sliderTimer extends TimerTask{

                @Override
                public void run() {
                    HomeActivity2.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(sliderPager2.getCurrentItem()<lstSlides.size()-1){
                                sliderPager2.setCurrentItem(sliderPager2.getCurrentItem()+1);
                            }else{
                                sliderPager2.setCurrentItem(0);
                            }


                        }
            });

        }
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Noticacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void desplegarNotificacion(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_icon);
        builder.setContentTitle("Recomendacion del dia");
        builder.setContentText("Rambo: La ultima mision");
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA, 1000, 1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());

    }
}