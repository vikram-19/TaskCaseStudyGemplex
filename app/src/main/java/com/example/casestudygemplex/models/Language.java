package com.example.casestudygemplex.models;

public class Language {
    String language;
    int languageImage;

    public Language(String language, int languageImage) {
        this.language = language;
        this.languageImage = languageImage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLanguageImage() {
        return languageImage;
    }

    public void setLanguageImage(int languageImage) {
        this.languageImage = languageImage;
    }
}
