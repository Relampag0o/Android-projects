package com.example.josemainstadam.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.josemainstadam.R;
import com.example.josemainstadam.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    // this is a different way of retriveing an element.
    // we use this instead the view.FindByid!!

    private FragmentHomeBinding binding;

    // this is a list of the items that we are going to use in the card view.

    public static List<HomeCardItem> homeCardItems;

    // this is the method that is going to be called when the fragment is created.
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeCardItems = new ArrayList<>();
        addData();
        CardAdapter cardAdapter = new CardAdapter(homeCardItems, requireContext());
        binding.recyclerView.setAdapter(cardAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        return root;
    }

    // this is the method that is going to be called when the fragment is destroyed.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // method to add data.

    public void addData() {
        homeCardItems.add(new HomeCardItem(1, "Jhon_Doe3", R.drawable.person1, R.drawable.place1, "China", "Jhon_Doe3", "Exploring the Lake!", "20/11/2023"));
        homeCardItems.add(new HomeCardItem(2, "Clarkk_34", R.drawable.person2, R.drawable.place2, "Korea", "Clarkk_34", "Enjoying the Grand Canyon", "22/11/2023"));
        homeCardItems.add(new HomeCardItem(3, "Evans1", R.drawable.tyler1, R.drawable.place3, "South Korea", "Evans1", "Visiting Gyeongbokgung Palace", "24/11/2023"));
        homeCardItems.add(new HomeCardItem(4, "Lorena", R.drawable.person9, R.drawable.place4, "Greece", "Lorena", "Observing the Sydney Opera House", "26/11/2023"));
        homeCardItems.add(new HomeCardItem(5, "Coder_Juan", R.drawable.person7, R.drawable.place4jpg, "Germany", "Coder_Juan", "Touring the Berlin Wall", "28/11/2023"));
        homeCardItems.add(new HomeCardItem(6, "Laura", R.drawable.person8, R.drawable.collie, "France", "Laura", "My beautiful Collie!", "30/11/2023"));
        homeCardItems.add(new HomeCardItem(7, "Michael45", R.drawable.hacker, R.drawable.china, "China", "Michael45", "Exploring the Great Wall", "02/12/2023"));
        homeCardItems.add(new HomeCardItem(8, "Josemrl17", R.drawable.me, R.drawable.kr, "Korea", "Jose", "Visiting the Tower of the capital!", "04/12/2023"));

    }


}