package com.example.hot_sear.Function;

import com.example.hot_sear.Repositories.FirebaseRepository;
import com.example.hot_sear.Repositories.LocalStoreUserinfoRepository;

public class UsernameFunction implements IUsername {
    private FirebaseRepository firebaseRepository;
    private LocalStoreUserinfoRepository localStoreUserinfoRepository;
    public UsernameFunction(){
        firebaseRepository = new FirebaseRepository();
        localStoreUserinfoRepository = new LocalStoreUserinfoRepository();
    }
    @Override
    public void storeUsername(String username) {
        localStoreUserinfoRepository.storedata(username);
        firebaseRepository.storeUsername(username);

    }

    @Override
    public boolean getUsername() {
        return localStoreUserinfoRepository.getUserName();
    }
}
