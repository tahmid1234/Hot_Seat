package com.example.hot_sear.Function;

import com.example.hot_sear.Models.OccupiedChair;

public class OccupiedChairHelper {
    private OccupiedChair occupiedChair;



    public void makeChairOccupied(String username,String color){
        occupiedChair = new OccupiedChair(username,color);
    }
}
