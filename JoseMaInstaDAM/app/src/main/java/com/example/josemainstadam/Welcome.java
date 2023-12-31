package com.example.josemainstadam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.josemainstadam.R;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomescreen);

        // WE USE THE HANDLER TO MAKE THE APP SLEEP FOR SOME SECONDS.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivityIntent = new Intent(Welcome.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        }, 3000);
    }
}

