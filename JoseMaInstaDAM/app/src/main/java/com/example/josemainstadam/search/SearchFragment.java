package com.example.josemainstadam.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josemainstadam.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchFragment extends Fragment {
    private List<Person> persons;


    public SearchFragment() {
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

        persons.add(new Person(203, "JohnDoe", "John Doe", 15000000, R.drawable.person1));
        persons.add(new Person(204, "EmmaW", "Emma Watson", 18000000, R.drawable.emmawatson));
        persons.add(new Person(205, "ChrisEvans", "Chris Evans", 22000000, R.drawable.chrisevans));
        persons.add(new Person(206, "ArianaG", "Ariana Grande", 30000000, R.drawable.arianagrande));
        persons.add(new Person(207, "TomH", "Tom Hanks", 12000000, R.drawable.tomhanks));
        persons.add(new Person(208, "JenniferL", "Jennifer Lopez", 25000000, R.drawable.jenniferlopez));
        persons.add(new Person(209, "BradP", "Brad Pitt", 18000000, R.drawable.bradpitt));
        persons.add(new Person(210, "SelenaG", "Selena Gomez", 28000000, R.drawable.selenagomez));
        persons.add(new Person(211, "RobertD", "Robert Downey Jr.", 22000000, R.drawable.robertdowneyjr));
        persons.add(new Person(212, "TaylorS", "Taylor Swift", 32000000, R.drawable.taylorswift));




    }
}