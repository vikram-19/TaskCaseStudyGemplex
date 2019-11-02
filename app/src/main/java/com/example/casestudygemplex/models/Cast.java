package com.example.casestudygemplex.models;

public class Cast {
    int castImage;
    String castName;

    public Cast(int castImage, String castName) {
        this.castImage = castImage;
        this.castName = castName;
    }

    public int getCastImage() {
        return castImage;
    }

    public void setCastImage(int castImage) {
        this.castImage = castImage;
    }

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }
}
