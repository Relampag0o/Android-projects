package com.example.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Welcome extends Fragment {


    public Welcome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.welcome_fragment, container, false);
        TextView welcomeMessage = view.findViewById(R.id.welcomeText);
        Bundle args = getArguments();
        String username = args.getString("username");
        if (username != null) {
            // Mostrar un mensaje de bienvenida con el nombre del usuario
            welcomeMessage.setText("¡Welcome, " + username + "!");
        }
        return view;
    }

    public static Welcome newInstance(String username) {
        Welcome wFragment = new Welcome();
        Bundle args = new Bundle();
        args.putString("username", username);
        wFragment.setArguments(args);
        return wFragment;
    }


}