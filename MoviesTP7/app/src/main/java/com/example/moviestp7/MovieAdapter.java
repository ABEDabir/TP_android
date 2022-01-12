package com.example.moviestp7;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
     final List<Movie> moviesList;
     final List<MovieGender> moviesGenres;

    public MovieAdapter(List<Movie> movies, List<MovieGender> genres){
        moviesList = movies;
        moviesGenres = genres;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.movie_item, parent, false);

        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context=holder.itemView.getContext();
        Movie movie = moviesList.get(position);
        ImageView imageView = holder.movieImg;
        if (movie.getPoster_path() != null) {
            Glide.with(context).load("https://image.tmdb.org/t/p/original" + movie.getPoster_path()).into(imageView);
        } else {
            Glide.with(context).load("https://www.seekpng.com/png/detail/94-945337_open-transparent-background-movie-icon.png").into(imageView);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MovieInformationActivity.class);
                intent.putExtra("movie", movie);
                intent.putExtra("genres", getGenreById(movie.getGenre_ids(), moviesGenres));
                view.getContext().startActivity(intent);
            }

            public ArrayList<String> getGenreById(List<Integer> ids, List<MovieGender> genres) {
                ArrayList<String> genresText = new ArrayList<>();
                for (int n: ids) {
                    for (MovieGender g:
                            genres) {
                        if(n == g.getId()) {
                            genresText.add(g.getName());
                        }
                    }
                }
                return genresText;
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView movieImg;

        public ViewHolder(View itemView){
            super(itemView);
            movieImg = (ImageView) itemView.findViewById(R.id.movie_image);
        }
    }
}
