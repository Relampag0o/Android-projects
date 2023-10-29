package com.example.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Login extends Fragment {

    public Login() {
        // required empty constructor!
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        TextView notRegisteredTextView = view.findViewById(R.id.notRegistered);

        // method to comunicate with mainActivity and switch the fragment.
        notRegisteredTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( getActivity() != null && getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).switchToFragment(true);
                }
            }
        }


        );
        return view;
    }
}