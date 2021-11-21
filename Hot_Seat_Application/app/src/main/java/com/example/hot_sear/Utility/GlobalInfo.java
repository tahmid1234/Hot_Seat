package com.example.hot_sear.Utility;

import com.google.firebase.database.FirebaseDatabase;

public class GlobalInfo {

    //firebase instance
    public static final FirebaseDatabase Database = FirebaseDatabase.getInstance("https://hotseat-d98f0-default-rtdb.asia-southeast1.firebasedatabase.app/");
    //userInfo
    public static String User_Auth_Id ="";
    public static  String User_Username ="";

    //user node
    public static final String User_Node = "User";
    public static final String User_Name_Node = "UserName";
    //shared preference
    public static final String User_Info_Sp = "UserInfo";

    //invalid info
    public  static final String Invalid_Info = "Invalid";
}
