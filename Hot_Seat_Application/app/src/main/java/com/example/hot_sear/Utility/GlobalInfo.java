package com.example.hot_sear.Utility;

import android.content.SharedPreferences;

import com.google.firebase.database.FirebaseDatabase;

public class GlobalInfo {

    //firebase instance
    public static final FirebaseDatabase Firebase_Databse = FirebaseDatabase.getInstance("https://hotseat-d98f0-default-rtdb.asia-southeast1.firebasedatabase.app/");
    //userInfo
    public static String User_Auth_Id ="";
    public static  String User_Username ="";

    //shared preference

    public static SharedPreferences User_Info;

    //firebase node
    public static final String User_Node = "User";
    public static final String User_Name_Node = "UserName";
    public static final String Chair_Node = "Chairs";
    //shared preference
    public static final String User_Info_Sp = "UserInfo";

    //invalid info
    public  static final String Invalid_Info = "Invalid";

    //
    public static int[] Chair_Taken = new int[3];

    //
    public static final int Max_Chairs = 3;
    //
    public static final String Free_Chair_Color = "#090";
    public static final String Occupied_Chair_Color = "#900";

}
