package com.example.josemainstadam.fav;

public class SaveCardItem {

    private int id;

    private String author;
    private int image;
    private int imageuser;

    private boolean saved;

    public SaveCardItem(int id, String author, int image, int imageuser) {
        this.id = id;
        this.author = author;
        this.image = image;
        this.imageuser = imageuser;
        this.saved = true;

    }

    public int getImageuser() {
        return imageuser;
    }

    public void setImageuser(int imageuser) {
        this.imageuser = imageuser;
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
