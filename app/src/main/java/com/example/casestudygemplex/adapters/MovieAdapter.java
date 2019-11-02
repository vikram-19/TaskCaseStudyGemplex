package com.example.casestudygemplex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.casestudygemplex.R;
import com.example.casestudygemplex.activities.DetailActivity;
import com.example.casestudygemplex.models.Cast;
import com.example.casestudygemplex.models.Movies;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movies> moviesList;

    public MovieAdapter(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movies movies = moviesList.get(position);
        holder.ivMovie.setImageResource(movies.getThumbnail());
        holder.tvMovieTitle.setText(movies.getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivMovie;
        private TextView tvMovieTitle;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivMovie =itemView.findViewById(R.id.ivMovie);
            tvMovieTitle =itemView.findViewById(R.id.tvMovieTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra("movieBanner",moviesList.get(getAdapterPosition()).getCoverPhoto());
                    intent.putExtra("movieTitle",moviesList.get(getAdapterPosition()).getTitle());
                    intent.putExtra("movieDesc",moviesList.get(getAdapterPosition()).getDescription());

                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
