package com.example.josemainstadam.search;


import com.google.firebase.firestore.DocumentSnapshot;

public class Person {
    private int id;
    private String username;
    private String fullName;
    private int followerCount;
    private int imageResource;


    public Person(DocumentSnapshot document) {
        this.id = document.getLong("id").intValue();
        this.username = document.getString("username");
        this.fullName = document.getString("fullName");
        this.followerCount = document.getLong("followerCount").intValue();
        // need to add a way to get the picture
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public int getImageResource() {
        return imageResource;
    }
}

