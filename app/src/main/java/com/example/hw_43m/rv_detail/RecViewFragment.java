package com.example.hw_43m.rv_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw_43m.DetailFragment;
import com.example.hw_43m.OnItemClick;
import com.example.hw_43m.R;
import com.example.hw_43m.databinding.FragmentRecViewBinding;

import java.util.ArrayList;

public class RecViewFragment extends Fragment implements OnItemClick {

    FragmentRecViewBinding binding;
    ArrayList<DetailModel> detailList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String item = getArguments() != null ? getArguments().getString("item") : "";
        initAdapter();
        loadData(item);
    }

    private void initAdapter() {
        RecViewAdapter adapter = new RecViewAdapter(detailList, this);
        binding.rvDetail.setAdapter(adapter);
    }

    private void loadData(String item) {
        detailList.clear();
        if (item.equals("Pizza")) {
            detailList.add(new DetailModel("pepperoni", "https://i.pinimg.com/originals/45/eb/98/45eb98c8637d591a1bde451eb1bce941.png", "45$", "Pizza"));
            detailList.add(new DetailModel("pepperoni", "https://i.pinimg.com/originals/45/eb/98/45eb98c8637d591a1bde451eb1bce941.png", "45$", "Pizza"));
            detailList.add(new DetailModel("pepperoni", "https://i.pinimg.com/originals/45/eb/98/45eb98c8637d591a1bde451eb1bce941.png", "45$", "Pizza"));
            detailList.add(new DetailModel("pepperoni", "https://i.pinimg.com/originals/45/eb/98/45eb98c8637d591a1bde451eb1bce941.png", "45$", "Pizza"));
            detailList.add(new DetailModel("pepperoni", "https://i.pinimg.com/originals/45/eb/98/45eb98c8637d591a1bde451eb1bce941.png", "45$", "Pizza"));
            detailList.add(new DetailModel("pepperoni", "https://i.pinimg.com/originals/45/eb/98/45eb98c8637d591a1bde451eb1bce941.png", "45$", "Pizza"));
        } else if (item.equals("Juice")) {
            detailList.add(new DetailModel("Cola", "https://static.vecteezy.com/system/resources/previews/026/755/602/non_2x/fresh-and-cold-soft-drinks-ai-generative-free-png.png", "10$", "CocaCola"));
            detailList.add(new DetailModel("Cola", "https://static.vecteezy.com/system/resources/previews/026/755/602/non_2x/fresh-and-cold-soft-drinks-ai-generative-free-png.png", "10$", "CocaCola"));
            detailList.add(new DetailModel("Cola", "https://static.vecteezy.com/system/resources/previews/026/755/602/non_2x/fresh-and-cold-soft-drinks-ai-generative-free-png.png", "10$", "CocaCola"));
            detailList.add(new DetailModel("Cola", "https://static.vecteezy.com/system/resources/previews/026/755/602/non_2x/fresh-and-cold-soft-drinks-ai-generative-free-png.png", "10$", "CocaCola"));
            detailList.add(new DetailModel("Cola", "https://static.vecteezy.com/system/resources/previews/026/755/602/non_2x/fresh-and-cold-soft-drinks-ai-generative-free-png.png", "10$", "CocaCola"));
            detailList.add(new DetailModel("Cola", "https://static.vecteezy.com/system/resources/previews/026/755/602/non_2x/fresh-and-cold-soft-drinks-ai-generative-free-png.png", "10$", "CocaCola"));
        } else if (item.equals("Combo")) {
            detailList.add(new DetailModel("Combo", "https://img.freepik.com/free-psd/top-view-pizza-isolated_23-2151361763.jpg", "30$", "Comboooo"));
            detailList.add(new DetailModel("Combo", "https://img.freepik.com/free-psd/top-view-pizza-isolated_23-2151361763.jpg", "30$", "Comboooo"));
            detailList.add(new DetailModel("Combo", "https://img.freepik.com/free-psd/top-view-pizza-isolated_23-2151361763.jpg", "30$", "Comboooo"));
            detailList.add(new DetailModel("Combo", "https://img.freepik.com/free-psd/top-view-pizza-isolated_23-2151361763.jpg", "30$", "Comboooo"));
            detailList.add(new DetailModel("Combo", "https://img.freepik.com/free-psd/top-view-pizza-isolated_23-2151361763.jpg", "30$", "Comboooo"));
            detailList.add(new DetailModel("Combo", "https://img.freepik.com/free-psd/top-view-pizza-isolated_23-2151361763.jpg", "30$", "Comboooo"));
        }
    }

    @Override
    public void onClick(int position) {
        DetailModel pizza = detailList.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("pizza", pizza);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }
}