package com.example.hot_sear.Function;

import com.example.hot_sear.Models.OccupiedChair;
import com.example.hot_sear.Repositories.FirebaseChairDataRepository;

public class OccupiedChairHelper {
    private OccupiedChair occupiedChair;
    private FirebaseChairDataRepository firebaseChairDataRepository;

    public OccupiedChairHelper() {
        firebaseChairDataRepository = new FirebaseChairDataRepository();
    }

    public void makeChairOccupied(String username, String color,int i){
        occupiedChair = new OccupiedChair(username,color);
        firebaseChairDataRepository.storeChairState(occupiedChair,i);
    }
}
