package com.example.hot_sear.Repositories;

import android.content.SharedPreferences;

import com.example.hot_sear.Utility.GlobalInfo;

public class ChairStateLocalData {

    public int getChairState(){
       return GlobalInfo.Chair_State_Sp.getInt(GlobalInfo.Chair_State,-1);
    }

    public void storeChairSTate(int value){
        GlobalInfo.Chair_State_Sp.edit().putInt(GlobalInfo.Chair_State,value).apply();
    }


}
