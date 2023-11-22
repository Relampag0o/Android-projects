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
import com.example.josemainstadam.Fav;
import com.example.josemainstadam.R;
import com.example.josemainstadam.databinding.FragmentHomeBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public static List<CardItem> cardItems;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        cardItems = new ArrayList<>();
        cardItems.add(new CardItem("User1", R.drawable.hacker, R.drawable.china));
        cardItems.add(new CardItem("User2", R.drawable.hacker2, R.drawable.us));
        cardItems.add(new CardItem("User1", R.drawable.hacker, R.drawable.kr));
        cardItems.add(new CardItem("User2", R.drawable.hacker2, R.drawable.collie));
        cardItems.add(new CardItem("User1", R.drawable.hacker, R.drawable.hacker));
        cardItems.add(new CardItem("User2", R.drawable.hacker2, R.drawable.hacker));
        cardItems.add(new CardItem("User1", R.drawable.hacker, R.drawable.hacker));
        cardItems.add(new CardItem("User2", R.drawable.hacker2, R.drawable.hacker));
        Log.d("SIZE IN HOME:", cardItems.size() + "");
        CardAdapter cardAdapter = new CardAdapter(cardItems, requireContext());
        binding.recyclerView.setAdapter(cardAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        binding.recyclerView.setLayoutManager(layoutManager);

        // CODE FOR THE LIST:
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public List<CardItem> getCardItems() {
        return cardItems;
    }


}