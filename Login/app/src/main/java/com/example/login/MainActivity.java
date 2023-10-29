package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    // declaring both fragments and a list with few users:
    public LinkedList<User> users;

    Register registerFragment;
    Login loginFragment;

    Welcome welcFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create instances for the fragments:
        loginFragment = new Login();
        registerFragment = new Register();
        welcFragment = new Welcome();

        // required for the linkedlist
        users = new LinkedList<User>();
        users.add(new User("Jose", "jmrodriguezl21@iesalbarregas.es", "admin"));
        users.add(new User("Marina", "mpreciados@iesalbarregas.es", "teacher"));


    }

    // this method comunicates the fragments with the main activity.
    // based on that, the fragment will be changed.
    // we also send the username to be sent as arg to the welcome fragment,
    // so the welcome_fragment can greet the user that has logged in.

    public void switchToFragment(String fragment,String username) {


        Fragment requiredFragment = null;

        switch (fragment) {

            case "login":
                requiredFragment = loginFragment;
                break;
            case "register":
                requiredFragment = registerFragment;
                break;
            case "welcome":
                requiredFragment = welcFragment;
                Bundle args = new Bundle();
                args.putString("username", username);
                requiredFragment.setArguments(args);
                break;


        }


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, requiredFragment)
                .addToBackStack(null)
                .commit();
    }


    // this method adds an user to the users list from the register fragment.
    // it changes the fragment with the previous method switchToFragment() and then adds the user.
    public void addUser(String name, String email, String pw) {
        switchToFragment("register","");
        users.add(new User(name, email, pw));

    }

    public void validateUser(String email, String pw) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equalsIgnoreCase(pw))
                switchToFragment("welcome",u.getName());
        }
    }


}


