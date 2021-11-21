package com.example.hot_sear.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hot_sear.Dialogs.UsernameDialogBox;
import com.example.hot_sear.R;
import com.example.hot_sear.Repositories.LocalStoreRepository;
import com.example.hot_sear.Utility.GlobalInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {
    private SharedPreferences userInfo;
    private LocalStoreRepository localStoreRepository;
    private DatabaseReference myRef = GlobalInfo.Database.getReference(GlobalInfo.User_Auth_Id);
    private UsernameDialogBox usernameDialogBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getUserName();
        System.out.println("Heloooooooo"+GlobalInfo.User_Username);
        Toast.makeText(this, GlobalInfo.User_Username+" global user name", Toast.LENGTH_SHORT).show();
        usernameDialogBox = new UsernameDialogBox();


    }

    public void getUserName(){
        userInfo = getSharedPreferences(GlobalInfo.User_Auth_Id,MODE_PRIVATE);
        localStoreRepository = new LocalStoreRepository(userInfo);
        if(!localStoreRepository.getUserName())
            getUserNameFromFirebase();
    }

    private void getUserNameFromFirebase(){
        // Read from the database
        //myRef.child(GlobalInfo.User_Name_Node).setValue("Hello, World!");
        myRef.child(GlobalInfo.User_Name_Node).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if(dataSnapshot.exists()) {
                    GlobalInfo.User_Username = dataSnapshot.getValue(String.class);
                    System.out.println("Global Useroooo Name" + GlobalInfo.User_Username);
                    System.out.println(dataSnapshot + " Datasnapshot");
                    //Log.d(TAG, "Value is: " + value);
                }
                else{
                    usernameDialogBox.show(getSupportFragmentManager(),"Username");
                }
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