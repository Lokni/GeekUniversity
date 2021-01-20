package ru.dmkalvan.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SwitchCompat theme = findViewById(R.id.theme_switch_btn);
        theme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                setTheme(R.style.dark_theme);
            } else {
                setTheme(R.style.light_theme);
            }
        });
    }
}