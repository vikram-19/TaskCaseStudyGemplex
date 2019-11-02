package com.example.casestudygemplex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.casestudygemplex.R;
import com.example.casestudygemplex.models.Movies;

import java.util.List;

public class RecommendedMovieAdapter extends RecyclerView.Adapter<RecommendedMovieAdapter.ViewHolder> {

    Context context;
    List<Movies> moviesList;

    public RecommendedMovieAdapter(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_reommend,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movies movies = moviesList.get(position);
        holder.ivRecommended.setImageResource(movies.getThumbnail());
        holder.tvRecommended.setText(movies.getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivRecommended;
        private TextView tvRecommended;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecommended =itemView.findViewById(R.id.ivRecommended);
            tvRecommended =itemView.findViewById(R.id.tvRecommended);
        }
    }
}
