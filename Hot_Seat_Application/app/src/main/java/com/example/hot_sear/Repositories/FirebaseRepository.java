package com.example.hot_sear.Repositories;

import com.example.hot_sear.Utility.GlobalInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class FirebaseRepository {
    private String userName;

    private DatabaseReference myRef = GlobalInfo.Database.getReference(GlobalInfo.User_Auth_Id);
    public void getUserNameFromFirebase(){
        // Read from the database
        //myRef.child(GlobalInfo.User_Name_Node).setValue("Hello, World!");
        myRef.child(GlobalInfo.User_Name_Node).addValueEventListener(new ValueEventListener() {
            {System.out.println("Ashe nai naki"+GlobalInfo.User_Auth_Id);}
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                GlobalInfo.User_Username = dataSnapshot.getValue(String.class);
                System.out.println("Global User Name"+ GlobalInfo.User_Username);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("error "+error);
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
