package com.example.josemainstadam;


public class CardItem {
    private String username;
    private int userImageResource;
    private int mainImageResource;

    private boolean liked;

    public CardItem(String username, int userImageResource, int mainImageResource) {
        this.username = username;
        this.userImageResource = userImageResource;
        this.mainImageResource = mainImageResource;
        this.liked = false;
    }

    public String getUsername() {
        return username;
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
}

