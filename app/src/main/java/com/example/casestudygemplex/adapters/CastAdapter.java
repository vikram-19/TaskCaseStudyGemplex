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
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    Context context;
    List<Cast> castList;

    public CastAdapter(Context context, List<Cast> castList) {
        this.context = context;
        this.castList = castList;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_cast, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        Glide.with(context).load(castList.get(position).getCastImage()).into(holder.ivCast);
        holder.tvCastName.setText(castList.get(position).getCastName());
    }

    @Override
    public int getItemCount() {
        return castList.size();
    }

    class CastViewHolder extends RecyclerView.ViewHolder {
        private CircularImageView ivCast;
        private TextView tvCastName;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCast = itemView.findViewById(R.id.ivCastImage);
            tvCastName = itemView.findViewById(R.id.tvCastName);

        }
    }
}
