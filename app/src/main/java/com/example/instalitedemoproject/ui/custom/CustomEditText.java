package com.example.instalitedemoproject.ui.custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.instalitedemoproject.R;

public class CustomEditText extends AppCompatEditText{
    public CustomEditText(Context context, AttributeSet atrrs) {
        super (context, atrrs);
        init();
    }

    public void init(){
        setBackgroundColor(Color.WHITE);
        setPadding(20, 20, 20, 20);
        setTextColor(Color.BLACK);
        setHintTextColor(Color.GRAY);
        setTextSize(16);
        setBackgroundResource(R.drawable.edittext_custom);
    }
}
