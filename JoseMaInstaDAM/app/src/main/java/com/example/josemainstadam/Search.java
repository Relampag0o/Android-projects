package com.example.josemainstadam;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Search extends Fragment {
    private List<Person> persons;


    public Search() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        persons = new ArrayList<>();
        createPersons();

        PersonAdapter personAdapter = new PersonAdapter(requireContext(), persons);

        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }


    public void createPersons() {

        String[] names = {"Juan", "Pepe", "Alfonso", "Roberto", "Marcos ", "Andres ", "Jose Maria "};
        String[] surnames = {"Lopez", "Gonzalez", "Rodriguez", "Fernandez", "Garcia", "Martinez", "Sanchez", "Perez", "Romero", "Diaz", "Torres", "Ruiz", "Serrano", "Santos", "Hernandez", "Jimenez", "Vazquez", "Navarro", "Molina", "Castro"};

        persons.add(new Person(201, "Dualipa", "DUA LIPA", 20000000, R.drawable.dualipa));
        persons.add(new Person(202, "Tyler", "Tyler1", 10000000, R.drawable.tyler1));

        Random r = new Random();

        for (int i = 1; i < 10; i++) {
            int picId = getResources().getIdentifier("person" + i, "drawable", getContext().getPackageName());
            persons.add(new Person(i, names[r.nextInt(names.length - 1)], surnames[r.nextInt(surnames.length - 1)], r.nextInt(250000), picId));
        }

    }
}