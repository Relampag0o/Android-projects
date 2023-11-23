package com.example.josemainstadam;


public class Person {
    private int id;
    private String username;
    private String fullName;
    private int followerCount;
    private int imageResource;

    public Person(int id, String username, String fullName, int followerCount, int imageResource) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.followerCount = followerCount;
        this.imageResource = imageResource;
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

