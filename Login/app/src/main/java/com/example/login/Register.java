package com.example.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends Fragment {
    ImageButton gBack;
    EditText name;
    EditText email;
    EditText pw;

    public Register() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // instance the elements to work with them:

        gBack = view.findViewById(R.id.backButton);
        name = view.findViewById(R.id.nameText);
        email = view.findViewById(R.id.emailText);
        pw = view.findViewById(R.id.pwRegisterText);
        Button submit = view.findViewById(R.id.submitButton);

        // add required listeners:
        // i need to check if the instance of the method is the main one, couldve used getClass() aswell.

        gBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null && getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).switchToFragment("login", "");
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = name.getText().toString();
                String emailStr = email.getText().toString();
                String pwStr = pw.getText().toString();

                if (!nameStr.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailStr).matches() && !pwStr.isEmpty()) {
                    if (getActivity() != null && getActivity() instanceof MainActivity) {
                        ((MainActivity) getActivity()).addUser(nameStr, emailStr, pwStr);
                    }
                    name.setText("");
                    email.setText("");
                    pw.setText("");
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(emailStr).matches()) {
                        email.setError("Not valid email.");
                    } else {
                        if (getActivity() != null) {
                            Toast.makeText(getActivity(), "Please, insert valid characters.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        return view;
    }
}