package com.example.moviestp7;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRepository {
    public MoviesAPICalls getMovies(){
        return new Retrofit.Builder()
                .baseUrl(MoviesAPICalls.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesAPICalls.class);
    }
}
