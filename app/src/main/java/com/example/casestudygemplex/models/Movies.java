package com.example.casestudygemplex.models;

import java.util.ArrayList;
import java.util.List;

public class Movies {

    private String title;
    private String description;
    private int thumbnail;
    private int coverPhoto;

    public Movies(String title, int thumbnail,int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movies(String title, String description, int thumbnail, int coverPhoto) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }


}
