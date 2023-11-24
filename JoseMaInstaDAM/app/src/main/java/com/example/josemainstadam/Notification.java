package com.example.josemainstadam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josemainstadam.ui.NewAdapter;
import com.example.josemainstadam.ui.NewItem;
import com.example.josemainstadam.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class Notification extends Fragment {
    List<NewItem> newItems;


    public Notification() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        newItems = new ArrayList<>();

        newItems.add(new NewItem(R.drawable.machine, "Advances in AI Technology", "The latest developments in artificial intelligence are changing the way we interact with technology. From virtual assistants to autonomous vehicles, AI is everywhere.","Alfonso Castilla"));
        newItems.add(new NewItem(R.drawable.sport, "The Thrill of the Football Season", "The football season is in full swing, with teams battling it out for the top spot. Fans are eagerly following every match, cheering on their favorite teams and players.","Juan Perez"));
        newItems.add(new NewItem(R.drawable.watch, "The Joy of Cooking and Culinary Arts", "Cooking is a form of art that brings joy to many. From experimenting with new recipes to mastering culinary techniques, the kitchen is a place of creativity and delight.","Jhon Smith"));

        NewAdapter newAdapter = new NewAdapter(newItems, requireContext());
        recyclerView.setAdapter(newAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

    }
}