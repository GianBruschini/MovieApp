package com.example.movieapp.Interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    String app_id = "25d5c2a6";
    String app_key = "41b4d59bd6ed74ebf43f69c96b5f1761";

    /*@GET("/?type=movie")
    Call<SearchResponse> getMovieList(@Query("s") String param, @Query("page") int page);

    @GET("/")
    Call<Movie> getMovie(@Query("i") String id);

     */
}
