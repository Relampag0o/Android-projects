package com.example.josemainstadam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josemainstadam.databinding.FragmentFavBinding;
import com.example.josemainstadam.databinding.FragmentHomeBinding;
import com.example.josemainstadam.ui.SaveCardAdapter;
import com.example.josemainstadam.ui.SaveCardItem;
import com.example.josemainstadam.ui.home.HomeFragment;
import com.example.josemainstadam.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;


public class Fav extends Fragment {
    private FragmentFavBinding binding;

    List<CardItem> cardItems;
    List<SaveCardItem> favItems;


    public Fav() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return inflater.inflate(R.layout.fragment_fav, container, false);
        } else {
            return getView();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            cardItems = HomeFragment.cardItems;

        }

        // code to show configure the recyclerview.
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        cardItems = HomeFragment.cardItems;
        favItems = new ArrayList<>();
        setFavItems();

        SaveCardAdapter cardAdapter = new SaveCardAdapter(favItems, requireContext());
        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


    }

    public void setFavItems() {
        for (CardItem c : cardItems) {
            c.loadState(getContext());
            if (c.isLiked()) {
                favItems.add(new SaveCardItem(c.getUsername(), c.getMainImageResource()));
            }
        }


    }


}



