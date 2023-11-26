package com.example.josemainstadam.ui;

import com.example.josemainstadam.Category;

public class NewItem {

    private int imageResource;
    private String title;

    private String body;

    private String author;


    private Category cat;


    public NewItem(int imageResource, String title, String body, String author, Category c) {
        this.imageResource = imageResource;
        this.title = title;
        this.body = body;
        this.author = "by: " + author;
        this.cat = c;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }
}
