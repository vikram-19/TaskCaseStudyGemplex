package com.example.casestudygemplex.models;

public class Genres {
    String genresTitle;
    int genresImage;

    public Genres(String genresTitle, int genresImage) {
        this.genresTitle = genresTitle;
        this.genresImage = genresImage;
    }

    public String getGenresTitle() {
        return genresTitle;
    }

    public void setGenresTitle(String genresTitle) {
        this.genresTitle = genresTitle;
    }

    public int getGenresImage() {
        return genresImage;
    }

    public void setGenresImage(int genresImage) {
        this.genresImage = genresImage;
    }
}
