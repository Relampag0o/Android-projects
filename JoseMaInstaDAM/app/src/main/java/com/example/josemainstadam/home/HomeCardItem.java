package com.example.josemainstadam.home;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.Random;

public class HomeCardItem {
    private int id;
    private String username;
    private int userImageResource;
    private int mainImageResource;
    private boolean liked;
    private int likes;
    private String location;
    private String uploader;
    private String description;
    private String date;

    public HomeCardItem(int id, String username, int userImageResource, int mainImageResource, String location, String uploader, String description, String date) {
        Random r = new Random();
        this.id = id;
        this.username = username;
        this.userImageResource = userImageResource;
        this.mainImageResource = mainImageResource;
        this.liked = false;
        this.likes = r.nextInt(5000);
        this.location = location;
        this.uploader = uploader;
        this.description = description;
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

