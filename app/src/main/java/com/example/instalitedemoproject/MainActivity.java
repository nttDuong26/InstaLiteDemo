package com.example.instalitedemoproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.instalitedemoproject.R; // Import R để tránh lỗi

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Gán layout chính của app
    }
}
