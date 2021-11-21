package com.example.hot_sear.Repositories;

import com.example.hot_sear.Models.OccupiedChair;
import com.example.hot_sear.Utility.GlobalInfo;

public class FirebaseChairDataRepository {
    public void storeChairState(OccupiedChair occupiedChair,int i){
        GlobalInfo.Firebase_Databse.getReference(GlobalInfo.Chair_Node).child(i+"").setValue(occupiedChair);
    }
}
