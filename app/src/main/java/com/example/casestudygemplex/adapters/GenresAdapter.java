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
import com.example.casestudygemplex.models.Genres;
import com.example.casestudygemplex.models.Movies;

import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {

    Context context;
    List<Genres> genresList;

    public GenresAdapter(Context context, List<Genres> genresList) {
        this.context = context;
        this.genresList = genresList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_genres,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Genres genres = genresList.get(position);
        holder.ivLanguage.setImageResource(genres.getGenresImage());
        holder.languageName.setText(genres.getGenresTitle());
    }

    @Override
    public int getItemCount() {
        return genresList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivLanguage;
        private TextView languageName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLanguage =itemView.findViewById(R.id.ivGenres);
            languageName =itemView.findViewById(R.id.txtGenres);
        }
    }
}
