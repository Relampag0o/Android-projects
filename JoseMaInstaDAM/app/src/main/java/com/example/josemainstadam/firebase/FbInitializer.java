package com.example.josemainstadam.firebase;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class FbInitializer extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
