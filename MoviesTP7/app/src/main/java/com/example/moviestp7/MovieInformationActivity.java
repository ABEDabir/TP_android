package com.example.moviestp7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieInformationActivity extends AppCompatActivity {

    ImageView imageView;
    TextView overView, releaseDate, genreText, release_date_text;
    ArrayList<String> genres;
    Movie movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_information);
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        imageView = (ImageView) findViewById(R.id.movie_img);
        overView = (TextView) findViewById(R.id.text_overview);
        releaseDate = (TextView) findViewById(R.id.release_date);
        release_date_text = (TextView) findViewById(R.id.release_date_text);
        genreText = (TextView) findViewById(R.id.gender_text_view);
        Intent intent = getIntent();
        movie = (Movie) intent.getSerializableExtra("movie");
        setTitle(movie.title + " Overview");
        genres = intent.getStringArrayListExtra("genres");
        if (movie.getBackdrop_path() != null) {
            Picasso.get().load("https://image.tmdb.org/t/p/original" + movie.getBackdrop_path()).into(imageView);
        } else {
            Picasso.get().load("https://www.seekpng.com/png/detail/94-945337_open-transparent-background-movie-icon.png").into(imageView);
        }
        overView.setText(!movie.getOverview().equals("") ? movie.getOverview(): "No overview founded");
        release_date_text.setText(movie.getRelease_date());
        StringBuilder genresMovies = new StringBuilder();
        for (String genre: genres) {
            genresMovies.append(" - ").append(genre).append("\n");
        }
        genreText.setText(!genresMovies.toString().equals("") ? genresMovies.toString() : "No genres founded");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}