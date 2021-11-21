package com.example.hot_sear.Models;

public class OccupiedChair {
    private String takenBy="";
    private String chairColor="j";

    public OccupiedChair() {
    }

    public String getTakenBy() {
        return takenBy;
    }

    public String getChairColor() {
        return chairColor;
    }

    public OccupiedChair(String takenBy, String chairColor) {
        this.takenBy = takenBy;
        this.chairColor = chairColor;
    }
}
