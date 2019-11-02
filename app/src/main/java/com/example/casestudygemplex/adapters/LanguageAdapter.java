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
import com.example.casestudygemplex.models.Language;
import com.example.casestudygemplex.models.Movies;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    Context context;
    List<Language> languageList;

    public LanguageAdapter(Context context, List<Language> languageList) {
        this.context = context;
        this.languageList = languageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.languages,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Language language = languageList.get(position);
        holder.ivLanguage.setImageResource(language.getLanguageImage());
        holder.languageName.setText(language.getLanguage());
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivLanguage;
        private TextView languageName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLanguage =itemView.findViewById(R.id.ivLanguage);
            languageName =itemView.findViewById(R.id.languageName);
        }
    }
}
