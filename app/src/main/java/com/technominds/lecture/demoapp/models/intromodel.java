package com.technominds.lecture.demoapp.models;

public class intromodel {
    int images;
    String title,desciption;

    public intromodel(int images, String title, String desciption) {
        this.images = images;
        this.title = title;
        this.desciption = desciption;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
