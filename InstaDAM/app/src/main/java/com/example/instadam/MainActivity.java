package com.example.instadam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbarTop = findViewById(R.id.menuTop);
        setSupportActionBar(toolbarTop);
        BottomNavigationView bottomNavigation = findViewById(R.id.menuBot);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_menu, bottomNavigation.getMenu());

        bottomNavigation.setOnItemSelectedListener(item -> {
            int idItem = item.getItemId();
            Fragment f = null;

            if (idItem == R.id.action_home)
                f = new Home();
            if (idItem == R.id.action_search)
                f = new Search();
            if (idItem == R.id.action_notifications)
                f = new Notification();

            if (f != null)
                loadFragment(f);


            return true;
        });
    }


    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.commit();
    }
}
