package com.example.instalitedemoproject.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.example.instalitedemoproject.R;

public class CustomButton extends AppCompatButton {

    public CustomButton(Context context) {
        super(context);
        init(null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        int defaultBackgroundColor = ContextCompat.getColor(getContext(), R.color.primary_color);
        int defaultTextColor = ContextCompat.getColor(getContext(), R.color.white);
        int defaultBorderColor = defaultBackgroundColor;

        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomButton);
            int backgroundColor = ta.getColor(R.styleable.CustomButton_btnBackgroundColor, defaultBackgroundColor);
            int textColor = ta.getColor(R.styleable.CustomButton_btnTextColor, defaultTextColor);
            int borderColor = ta.getColor(R.styleable.CustomButton_btnBorderColor, defaultBorderColor);
            ta.recycle();

            setCustomStyle(backgroundColor, textColor, borderColor);
        } else {
            setCustomStyle(defaultBackgroundColor, defaultTextColor, defaultBorderColor);
        }
    }

    private void setCustomStyle(int backgroundColor, int textColor, int borderColor) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(16);
        drawable.setColor(backgroundColor);
        drawable.setStroke(4, borderColor); // Viền 4px

        setBackground(drawable);
        setTextColor(textColor);
        setAllCaps(false);
        setTextSize(16);
        setPadding(20, 10, 20, 10);
    }
}
