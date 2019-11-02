package com.example.casestudygemplex.models;

public class Crew {
    int crewImage;
    String crewName;

    public Crew(int crewImage, String crewName) {
        this.crewImage = crewImage;
        this.crewName = crewName;
    }

    public int getCrewImage() {
        return crewImage;
    }

    public void setCrewImage(int crewImage) {
        this.crewImage = crewImage;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }
}
