package com.example.movietdb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<ResponseModel> arraylist;
    private Context context;

    public Adapter(ArrayList<ResponseModel> arraylist, Context context) {
        this.arraylist = arraylist;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design_movie, null);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.basename.setText(arraylist.get(position).getOriginal_title());
        holder.overview.setText(arraylist.get(position).getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/" + arraylist.get(position).getPoster_path()).into(holder.imageView);
        holder.releasedate.setText("Release Date:" + arraylist.get(position).getRelease_date());
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView basename, overview, releasedate;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            basename = itemView.findViewById(R.id.basename);
            overview = itemView.findViewById(R.id.overview);
            imageView = itemView.findViewById(R.id.image1);
            releasedate = itemView.findViewById(R.id.releasedate);
        }


    }

}