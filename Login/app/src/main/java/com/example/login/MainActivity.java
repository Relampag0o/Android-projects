package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    // declaring both fragments and a list with few users:
    public LinkedList<User> users;

    Register registerFragment;
    Login loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create instances for the fragments:
        loginFragment = new Login();
        registerFragment = new Register();
        users = new LinkedList<User>();
        users.add(new User("jose", "jmrodriguezl21@iesalbarregas.es", "admin"));


    }

    // this method comunicates the not Registered text in the login_fragment with the main activity.
    public void onNotRegisteredClicked() {
        // Cambiar al fragmento de registro cuando se haga clic en el enlace
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, registerFragment)
                .addToBackStack(null)
                .commit();
    }


}