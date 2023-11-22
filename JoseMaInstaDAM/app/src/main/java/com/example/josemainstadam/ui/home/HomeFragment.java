package com.example.josemainstadam.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.josemainstadam.CardAdapter;
import com.example.josemainstadam.CardItem;
import com.example.josemainstadam.R;
import com.example.josemainstadam.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        List<CardItem> cardItems = new ArrayList<>();
        cardItems.add(new CardItem("User1", R.drawable.hacker, R.drawable.hacker));
        cardItems.add(new CardItem("User2", R.drawable.hacker2, R.drawable.hacker));
        CardAdapter cardAdapter = new CardAdapter(cardItems, requireContext());
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
}