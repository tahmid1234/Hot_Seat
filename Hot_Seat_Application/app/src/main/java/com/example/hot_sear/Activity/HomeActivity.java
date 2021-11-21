package com.example.hot_sear.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hot_sear.Dialogs.UsernameDialogBox;
import com.example.hot_sear.Function.IUsername;
import com.example.hot_sear.Function.UsernameFunction;
import com.example.hot_sear.Models.OccupiedChair;
import com.example.hot_sear.R;
import com.example.hot_sear.Repositories.LocalStoreUserinfoRepository;
import com.example.hot_sear.Utility.GlobalInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    private LocalStoreUserinfoRepository localStoreUserinfoRepository;
    private DatabaseReference myRef = GlobalInfo.Firebase_Databse.getReference(GlobalInfo.User_Auth_Id);
    private UsernameDialogBox usernameDialogBox;
    private IUsername usernameFunction;
    private ImageButton[] chairs;
    private TextView[] x_btn;
    private TextView[] takenBy;
    private OccupiedChair[] occupiedChairs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chairs = new ImageButton[3];
        x_btn = new TextView[GlobalInfo.Max_Chairs];
        takenBy = new TextView[GlobalInfo.Max_Chairs];
        occupiedChairs = new OccupiedChair[GlobalInfo.Max_Chairs];
        chairs[0] = findViewById(R.id.chair1);
        chairs[1] = findViewById(R.id.chair2);
        chairs[2] = findViewById(R.id.chair3);
        x_btn[0] = findViewById(R.id.x1);
        x_btn[1] = findViewById(R.id.x2);
        x_btn[2] = findViewById(R.id.x3);
        takenBy[0] = findViewById(R.id.occupied1);
        takenBy[1] = findViewById(R.id.occupied2);
        takenBy[2] = findViewById(R.id.occupied3);
        disableBtn(chairs);
        System.out.println("Heloooooooo"+GlobalInfo.User_Auth_Id);
        getUserName();
        Toast.makeText(this, GlobalInfo.User_Username+" global user name", Toast.LENGTH_SHORT).show();
        usernameDialogBox = new UsernameDialogBox();
        occupyChair();


    }

    public void getUserName(){
        GlobalInfo.User_Info = getSharedPreferences(GlobalInfo.User_Auth_Id,MODE_PRIVATE);
        //localStoreUserinfoRepository = new LocalStoreUserinfoRepository(userInfo);
        usernameFunction = new UsernameFunction();

        if(! usernameFunction.getUsername())
            getUserNameFromFirebase();
        else
            enableBtn(chairs);
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
                    usernameFunction.storeUsername(GlobalInfo.User_Username );
                }
                else{
                    usernameDialogBox.show(getSupportFragmentManager(),"Username");
                }
                enableBtn(chairs);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("error "+error);
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    private void occupyChair(){
        for(int i=0;i<3;i++){
            final int j =i;
            chairs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Kire ki khobor valo?"+j);
                }
            });
        }
    }

    private void getChairStatus(){
        myRef.child(GlobalInfo.Chair_Node).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    occupiedChairs[Integer.parseInt(ds.getKey())] = ds.getValue(OccupiedChair.class);
                    if(occupiedChairs[Integer.parseInt(ds.getKey())].getChairColor().equals(GlobalInfo.Occupied_Chair_Color))
                    {
                        GlobalInfo.Chair_Taken[Integer.parseInt(ds.getKey())] = 1;
                        updateChairState(occupiedChairs[Integer.parseInt(ds.getKey())],Integer.parseInt(ds.getKey()));
                    }
                    else {
                        GlobalInfo.Chair_Taken[Integer.parseInt(ds.getKey())] = 0;
                        updateChairState(occupiedChairs[Integer.parseInt(ds.getKey())],Integer.parseInt(ds.getKey()));
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void enableBtn(ImageButton[] chairs){
        for(ImageButton chair:chairs)
            chair.setEnabled(true);
        System.out.println("emables");
    }
    private void disableBtn(ImageButton[] chairs){
        for(ImageButton chair:chairs)
            chair.setEnabled(false);
        System.out.println("disables");
    }
    private void updateChairState(OccupiedChair occupiedChair,int i){
        takenBy[i].setText(occupiedChair.getTakenBy());
        chairs[i].setBackgroundColor(Color.parseColor(occupiedChair.getChairColor()));

    }
}