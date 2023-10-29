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

    // this method comunicates both fragments with the main activity.
    // based on the boolean, it changes the fragmentContainer to either the login or the register.
    public void switchToFragment(boolean isRegister) {
        Fragment targetFragment = isRegister ? registerFragment : loginFragment;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, targetFragment)
                .addToBackStack(null)
                .commit();
    }


}