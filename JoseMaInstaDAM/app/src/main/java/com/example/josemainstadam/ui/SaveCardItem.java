package com.example.josemainstadam.ui;

public class SaveCardItem {

    private int id;

    private String author;
    private int image;

    private boolean saved;

    public SaveCardItem(int id, String author, int image) {
        this.id = id;
        this.author = author;
        this.image = image;
        this.saved = true;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
