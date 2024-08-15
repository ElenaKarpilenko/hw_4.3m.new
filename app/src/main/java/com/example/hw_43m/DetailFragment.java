package com.example.hw_43m;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hw_43m.databinding.FragmentDetailBinding;
import com.example.hw_43m.rv_detail.DetailModel;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private DetailModel detailModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            detailModel = (DetailModel) getArguments().getSerializable("pizza");
            displayPizzaDetails();
        }
    }

    private void displayPizzaDetails() {
        if (detailModel != null) {
            binding.tvName.setText(detailModel.getName());
            binding.tvDesc.setText(detailModel.getDesc());
            binding.tvPrice.setText(detailModel.getPrice() + "$");
            Glide.with(this).load(detailModel.getImage()).into(binding.imgRv);
        }
    }
}