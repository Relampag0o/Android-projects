package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    NavigationFragment nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        nf = new NavigationFragment();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void loadFragment(String url) {
        Bundle b = new Bundle();
        b.putString("url", url);
        nf.setArguments(b);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, nf);
        transaction.addToBackStack(null);
        transaction.commit();


    }
}