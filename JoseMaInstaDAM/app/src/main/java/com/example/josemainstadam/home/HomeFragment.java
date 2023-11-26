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

    // this is a differente way of retriveing an element.
    // we use this instead the view.FindByid!!

    private FragmentHomeBinding binding;

    public static List<HomeCardItem> homeCardItems;

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // method to add data.

    public void addData() {
        homeCardItems.add(new HomeCardItem(1, "User1", R.drawable.person1, R.drawable.china, "China", "User1", "Exploring the Great Wall", "20/11/2023"));
        homeCardItems.add(new HomeCardItem(2, "User2", R.drawable.person2, R.drawable.us, "United States", "User2", "Enjoying the Grand Canyon", "22/11/2023"));
        homeCardItems.add(new HomeCardItem(3, "User1", R.drawable.tyler1, R.drawable.kr, "South Korea", "User1", "Visiting Gyeongbokgung Palace", "24/11/2023"));
        homeCardItems.add(new HomeCardItem(4, "User2", R.drawable.dualipa, R.drawable.collie, "Australia", "User2", "Observing the Sydney Opera House", "26/11/2023"));
        homeCardItems.add(new HomeCardItem(5, "User1", R.drawable.person7, R.drawable.hacker, "Germany", "User1", "Touring the Berlin Wall", "28/11/2023"));
        homeCardItems.add(new HomeCardItem(6, "User2", R.drawable.person8, R.drawable.hacker, "France", "User2", "Admiring the Eiffel Tower", "30/11/2023"));
        homeCardItems.add(new HomeCardItem(7, "User1", R.drawable.hacker, R.drawable.hacker, "Italy", "User1", "Exploring the Colosseum", "02/12/2023"));
        homeCardItems.add(new HomeCardItem(8, "User2", R.drawable.me, R.drawable.hacker, "United Kingdom", "User2", "Visiting the Tower of London", "04/12/2023"));

    }


}