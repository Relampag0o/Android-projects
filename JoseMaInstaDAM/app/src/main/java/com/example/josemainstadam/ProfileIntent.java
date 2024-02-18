package com.example.josemainstadam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.josemainstadam.login.LoginActivity;

public class ProfileIntent extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_nav_layout);

        Log.d("ProfileIntent", "ProfileIntent onCreate");
    }
}
