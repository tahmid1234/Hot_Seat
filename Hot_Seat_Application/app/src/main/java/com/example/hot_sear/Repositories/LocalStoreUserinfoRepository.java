package com.example.hot_sear.Repositories;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;

import com.example.hot_sear.Utility.GlobalInfo;

public class LocalStoreUserinfoRepository {
    SharedPreferences userInfo;
    private String userName;
    private FirebaseRepository firebaseRepository;
    public LocalStoreUserinfoRepository(){
       userInfo = GlobalInfo.User_Info;

    }
    public boolean getUserName(){
       userName = userInfo.getString(GlobalInfo.User_Auth_Id,GlobalInfo.Invalid_Info);
        System.out.println(userName+" sharedpref");
       if(!userName.equals("Invalid")) {
           GlobalInfo.User_Username = userName;
           return true;
       }

       return false;
    }

    public void storedata(String username){
        userInfo.edit().putString(GlobalInfo.User_Auth_Id,username).apply();
    }
}
