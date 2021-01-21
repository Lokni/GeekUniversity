package ru.dmkalvan.calculatorapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends AppCompatActivity {
    //    Settings name
    private static final String NameSharedPreference = "MyStyle";
    private static final String AppTheme = "APP_THEME";
    private static final int darkTheme = 0;
    private static final int lightTheme = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.dark_theme));
        setContentView(R.layout.activity_settings);
        initThemeChooser();
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonDark),
                darkTheme);
        initRadioButton(findViewById(R.id.radioButtonLight),
                lightTheme);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(darkTheme))).setChecked(true);
    }


    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }


    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        if (codeStyle == lightTheme) {
            return R.style.light_theme;
        }
        return R.style.dark_theme;
    }

}