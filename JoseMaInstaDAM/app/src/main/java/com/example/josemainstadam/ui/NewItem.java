package com.example.josemainstadam.ui;

public class NewItem {

    private int imageResource;
    private String title;

    private String body;


    public NewItem(int imageResource, String title, String body) {
        this.imageResource = imageResource;
        this.title = title;
        this.body = body;
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

}
