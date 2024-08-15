package com.example.hw_43m.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw_43m.OnItemClick;
import com.example.hw_43m.R;
import com.example.hw_43m.rv_detail.RecViewFragment;
import com.example.hw_43m.databinding.FragmentMenuBinding;

import java.util.ArrayList;

public class MenuFragment extends Fragment implements OnItemClick {

    FragmentMenuBinding binding;
    ArrayList<Menu> menuList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        loadData();
    }

    private void initAdapter() {
        MenuAdapter menuAdapter = new MenuAdapter(menuList,this);
        binding.rvMenu.setAdapter(menuAdapter);
    }
    private void loadData() {
        menuList.add(new Menu("Pizza","https://static.vecteezy.com/system/resources/thumbnails/027/141/485/small_2x/pizza-created-with-generative-ai-png.png"));
        menuList.add(new Menu("Juice","https://png.pngtree.com/png-vector/20240207/ourmid/pngtree-delicious-fruit-juices-png-image_11712372.png"));
        menuList.add(new Menu("Combo","https://imgpng.ru/d/pizza_PNG44090.png"));
    }

    @Override
    public void onClick(int position) {
        RecViewFragment rvFragment = new RecViewFragment();
        Bundle bundle = new Bundle();
        if (position == 0) {
            bundle.putString("item", "Pizza");
        } else if (position == 1) {
            bundle.putString("item", "Juice");
        } else if (position == 2) {
            bundle.putString("item", "Combo");
        }
        rvFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, rvFragment).addToBackStack(null).commit();

    }
}