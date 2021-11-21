package com.example.hot_sear.Repositories;

import android.content.SharedPreferences;

import com.example.hot_sear.Utility.GlobalInfo;

public class LocalStoreRepository {
    SharedPreferences userInfo;
    private String userName;
    private FirebaseRepository firebaseRepository;
    public LocalStoreRepository(SharedPreferences userInfo){
       this.userInfo = userInfo;
       firebaseRepository = new FirebaseRepository();
    }
    public boolean getUserName(){
       userName = userInfo.getString(GlobalInfo.User_Auth_Id,GlobalInfo.Invalid_Info);
       if(!userName.equals(GlobalInfo.Invalid_Info)) {
           GlobalInfo.User_Username = userName;
           return true;
       }
       firebaseRepository.getUserNameFromFirebase();
       return false;
    }
}
