package com.example.josemainstadam;


import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

public class CardItem {
    private int id;
    private String username;
    private int userImageResource;
    private int mainImageResource;

    private boolean liked;

    public CardItem(int id, String username, int userImageResource, int mainImageResource) {
        this.id = id;
        this.username = username;
        this.userImageResource = userImageResource;
        this.mainImageResource = mainImageResource;
        this.liked = false;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserImageResource() {
        return userImageResource;
    }

    public int getMainImageResource() {
        return mainImageResource;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserImageResource(int userImageResource) {
        this.userImageResource = userImageResource;
    }

    public void setMainImageResource(int mainImageResource) {
        this.mainImageResource = mainImageResource;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    // methods to save like status in the memory.
    public void saveState(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("CardItem", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("like_" + this.id, this.liked);
        editor.apply();
    }

    public void loadState(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("CardItem", Context.MODE_PRIVATE);
        this.liked = sharedPref.getBoolean("like_" + this.id, false);
    }
}

