package com.example.instalitedemoproject.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthRepository {
    private final FirebaseAuth auth;
    private final MutableLiveData<FirebaseUser> userLiveData;
    private final MutableLiveData<String> authError;

    public AuthRepository() {
        auth = FirebaseAuth.getInstance();
        userLiveData = new MutableLiveData<>();
        authError = new MutableLiveData<>();

        if (auth.getCurrentUser() != null) {
            userLiveData.postValue(auth.getCurrentUser());
        }
    }

    public LiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public LiveData<String> getAuthError() {
        return authError;
    }

    public void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        userLiveData.postValue(auth.getCurrentUser());
                    } else {
                        authError.postValue(task.getException().getMessage());
                    }
                });
    }

    public void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        userLiveData.postValue(auth.getCurrentUser());
                    } else {
                        authError.postValue(task.getException().getMessage());
                    }
                });
    }

    public void logout() {
        auth.signOut();
        userLiveData.postValue(null);
    }
}
