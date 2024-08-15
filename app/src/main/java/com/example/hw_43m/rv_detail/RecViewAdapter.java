package com.example.hw_43m.rv_detail;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hw_43m.OnItemClick;
import com.example.hw_43m.databinding.ItemDetailBinding;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewHolder> {

    ArrayList<DetailModel> detailModels;
    OnItemClick onItemClick;

    public RecViewAdapter(ArrayList<DetailModel> detailModels, OnItemClick onItemClick) {
        this.detailModels = detailModels;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecViewHolder(ItemDetailBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(detailModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailModels.size();
    }
}
class RecViewHolder extends RecyclerView.ViewHolder {

    ItemDetailBinding binding;

    public RecViewHolder(@NonNull ItemDetailBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void onBind(DetailModel detailModel){
        binding.tvName.setText(detailModel.getName());
        Glide.with(binding.imgRv).load(detailModel.getImage()).into(binding.imgRv);
    }
}
