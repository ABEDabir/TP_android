package com.example.moviestp7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Movie> popularMovies= new ArrayList<>();
    List<Movie> upcomingMovies =new ArrayList<>();
    List<Movie> searchedMovies =new ArrayList<>();
    List<MovieGender> genreList = new ArrayList<>();
    MoviesRepository movieRepository = new MoviesRepository();

    RecyclerView moviesRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getGenderList();
        getUpcomingMovies();
        getPopularMovies();
        ConfigureBottomNavigationView();
    }

    public void getPopularMovies()
    {
        movieRepository.getMovies().popularMovies().enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                moviesRecyclerView = (RecyclerView) findViewById(R.id.movies_recyclerView);
                popularMovies = response.body().getResults();
                MovieAdapter adapter = new MovieAdapter(popularMovies, genreList);
                moviesRecyclerView.setAdapter(adapter);
                moviesRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
            }
            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
            }
        });
    }

    public void getUpcomingMovies()
    {
        movieRepository.getMovies().upcomingMovies().enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                upcomingMovies = response.body().getResults();
            }
            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
            }
        });
    }

    public void getGenderList()
    {
        movieRepository.getMovies().genreList().enqueue(new Callback<MoviesGenderList>() {
            @Override
            public void onResponse(Call<MoviesGenderList> call, Response<MoviesGenderList> response) {
                genreList = response.body().getGenres();
            }
            @Override
            public void onFailure(Call<MoviesGenderList> call, Throwable t) {

            }
        });
    }

    public void ConfigureBottomNavigationView()
    {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch(item.getItemId())

                        {
                            case R.id.popular: {
                                Toast.makeText(getApplicationContext(), "Popular movies", Toast.LENGTH_LONG).show();
                                LinearLayout ln = (LinearLayout) findViewById(R.id.searchLayout);
                                ln.setVisibility(View.GONE);
                                MovieAdapter mAdapter = new MovieAdapter(popularMovies, genreList);
                                moviesRecyclerView.setAdapter(mAdapter);

                                return true;
                            }
                            case R.id.upcoming: {
                                Toast.makeText(getApplicationContext(), "Upcoming movies", Toast.LENGTH_LONG).show();
                                LinearLayout ln = (LinearLayout) findViewById(R.id.searchLayout);
                                ln.setVisibility(View.GONE);
                                MovieAdapter mAdapter = new MovieAdapter(upcomingMovies, genreList);
                                moviesRecyclerView.setAdapter(mAdapter);
                                return true;
                            }
                            case R.id.search: {
                                EditText movieName = findViewById(R.id.form_text);
                                movieName.setText("");
                                Toast.makeText(getApplicationContext(), "Search for movies", Toast.LENGTH_LONG).show();
                                LinearLayout ln=(LinearLayout)findViewById(R.id.searchLayout);
                                ln.setVisibility(View.VISIBLE);
                                MovieAdapter mAdapter = new MovieAdapter(new ArrayList<>(),new ArrayList<>());
                                moviesRecyclerView.setAdapter(mAdapter);
                                Button button = (Button) findViewById(R.id.form_botton);
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        movieRepository.getMovies().searchMovies(movieName.getText().toString()).enqueue(new Callback<MoviesList>() {
                                            @Override
                                            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                                                moviesRecyclerView = (RecyclerView) findViewById(R.id.movies_recyclerView);
                                                searchedMovies = response.body().getResults();
                                                MovieAdapter mAdapter = new MovieAdapter(searchedMovies, genreList);
                                                moviesRecyclerView.setAdapter(mAdapter);
                                            }
                                            @Override
                                            public void onFailure(Call<MoviesList> call, Throwable t) {
                                            }
                                        });
                                        View view = getCurrentFocus();
                                        if (view != null) {
                                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                                        }
                                    }
                                });
                                return true;
                            }
                            default: return false;
                        }
                    }

                });
    }
}