package com.example.casestudygemplex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.casestudygemplex.R;
import com.example.casestudygemplex.models.Cast;
import com.example.casestudygemplex.models.Crew;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewViewHolder> {

    Context context;
    List<Crew> crewList;

    public CrewAdapter(Context context, List<Crew> crewList) {
        this.context = context;
        this.crewList = crewList;
    }

    @NonNull
    @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_crew, parent, false);
        return new CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder holder, int position) {
        Glide.with(context).load(crewList.get(position).getCrewImage()).into(holder.ivCrew);
        holder.tvCrewName.setText(crewList.get(position).getCrewName());
    }

    @Override
    public int getItemCount() {
        return crewList.size();
    }

    class CrewViewHolder extends RecyclerView.ViewHolder {
        private CircularImageView ivCrew;
        private TextView tvCrewName;

        public CrewViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCrew = itemView.findViewById(R.id.ivCrewImage);
            tvCrewName = itemView.findViewById(R.id.tvCrewName);

        }
    }
}
