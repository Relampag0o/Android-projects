package com.example.josemainstadam.fav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josemainstadam.databinding.FragmentFavBinding;
import com.example.josemainstadam.home.HomeCardItem;
import com.example.josemainstadam.R;
import com.example.josemainstadam.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;


public class Fav extends Fragment {
    private FragmentFavBinding binding;

    List<HomeCardItem> homeCardItems;
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
            homeCardItems = HomeFragment.homeCardItems;

        }

        // code to show configure the recyclerview.
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        homeCardItems = HomeFragment.homeCardItems;
        favItems = new ArrayList<>();
        setFavItems();

        SaveCardAdapter cardAdapter = new SaveCardAdapter(homeCardItems, favItems, requireContext());
        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


    }

    public void setFavItems() {
        for (HomeCardItem c : homeCardItems) {
            c.loadState(getContext());
            if (c.isLiked()) {
                favItems.add(new SaveCardItem(c.getId(), c.getUsername(), c.getMainImageResource(),c.getUserImageResource()));
            }
        }


    }


}



