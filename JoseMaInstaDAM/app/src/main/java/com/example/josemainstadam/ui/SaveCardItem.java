package com.example.josemainstadam.ui;

public class SaveCardItem {

    private String author;
    private int image;

    public SaveCardItem(String author, int image) {
        this.author = author;
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
