package ru.dmkalvan.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dmkalvan.weatherapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}