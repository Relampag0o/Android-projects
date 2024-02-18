package com.example.josemainstadam.search;


import com.google.firebase.firestore.DocumentSnapshot;

public class Person {
    private int id;
    private String username;
    private String fullName;
    private String followerCount;
    private String imageResource;


    public Person(DocumentSnapshot document) {
        this.id = document.getLong("id").intValue();
        this.username = document.getString("username");
        this.fullName = document.getString("fullName");
        this.followerCount = document.getString("followerCount");
        this.imageResource = document.getString("imageResource");


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

    public String getFollowerCount() {
        return followerCount;
    }

    public String getImageResource() {
        return imageResource;
    }
}

