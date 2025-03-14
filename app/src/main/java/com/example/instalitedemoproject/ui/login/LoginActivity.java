package com.example.instalitedemoproject.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.instalitedemoproject.auth.AuthViewModel;
import com.example.instalitedemoproject.MainActivity;
import com.example.instalitedemoproject.R;
import com.example.instalitedemoproject.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnGoToRegister = findViewById(R.id.btnGoToRegister);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            authViewModel.loginUser(email, password);
        });

        btnGoToRegister.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        authViewModel.getUserLiveData().observe(this, user -> {
            if (user != null) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });

        authViewModel.getAuthError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, "Lỗi: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
