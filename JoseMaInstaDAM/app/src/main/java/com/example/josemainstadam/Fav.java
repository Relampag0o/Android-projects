package com.example.josemainstadam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josemainstadam.ui.home.HomeFragment;

import java.util.List;


public class Fav extends Fragment {
    List<CardItem> cardItems;


    public Fav() {
        // Required empty public constructor
    }
/*
    public static Fav newInstance(String param1, String param2) {

        return fragment;
    }

 */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

         */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_fav, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            cardItems = HomeFragment.cardItems;
            System.out.println("Hello " + cardItems.size());
            Log.d("SIZE: ", cardItems.size() + "");
        }
    }
}