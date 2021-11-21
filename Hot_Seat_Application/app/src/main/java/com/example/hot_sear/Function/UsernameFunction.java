package com.example.hot_sear.Function;

import com.example.hot_sear.Repositories.FirebaseRepository;
import com.example.hot_sear.Repositories.LocalStoreRepository;

public class UsernameFunction implements IUsername {
    private FirebaseRepository firebaseRepository;
    private LocalStoreRepository localStoreRepository;
    public UsernameFunction{

    }
    @Override
    public void storeUsername(String username) {

    }

    @Override
    public String getUsername() {
        return null;
    }
}
