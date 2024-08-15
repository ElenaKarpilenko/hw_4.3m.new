package com.example.hw_43m.menu;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hw_43m.OnItemClick;
import com.example.hw_43m.databinding.ItemMenuBinding;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    ArrayList<Menu> menuList;
    OnItemClick onItemClick;

    public MenuAdapter(ArrayList<Menu> menuList, OnItemClick onItemClick) {
        this.menuList = menuList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(menuList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
 class MenuViewHolder extends RecyclerView.ViewHolder {

    ItemMenuBinding binding;

    public MenuViewHolder(@NonNull ItemMenuBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void onBind(Menu menu){
        binding.tvName.setText(menu.getName());
        Glide.with(binding.imgMenu).load(menu.getImage()).into(binding.imgMenu);
    }
}

