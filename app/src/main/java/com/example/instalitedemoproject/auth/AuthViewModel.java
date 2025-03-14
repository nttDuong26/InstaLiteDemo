package com.example.instalitedemoproject.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.google.firebase.auth.FirebaseUser;

public class AuthViewModel extends ViewModel {
    private final AuthRepository authRepository;

    public AuthViewModel() {
        authRepository = new AuthRepository();
    }

    public LiveData<FirebaseUser> getUserLiveData() {
        return authRepository.getUserLiveData();
    }

    public LiveData<String> getAuthError() {
        return authRepository.getAuthError();
    }

    public void registerUser(String email, String password) {
        authRepository.registerUser(email, password);
    }

    public void loginUser(String email, String password) {
        authRepository.loginUser(email, password);
    }

    public void logout() {
        authRepository.logout();
    }
}
