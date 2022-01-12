package com.example.moviestp7;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPICalls {
    public static final String ENDPOINT = "https://api.themoviedb.org/3/";
    public static final String apiKey = "f242c606b7cce94e361e25ad4bb67a0a";

    @GET("movie/popular?api_key="+apiKey+"&language=en-US")
    Call<MoviesList> popularMovies();

    @GET("movie/upcoming?api_key="+apiKey+"&language=en-US")
    Call<MoviesList> upcomingMovies();

    @GET("genre/movie/list?api_key="+apiKey+"&language=en-US")
    Call<MoviesGenderList> genreList();
    @GET("search/movie?api_key="+apiKey)
    Call<MoviesList> searchMovies(@Query("query") String query);

}
