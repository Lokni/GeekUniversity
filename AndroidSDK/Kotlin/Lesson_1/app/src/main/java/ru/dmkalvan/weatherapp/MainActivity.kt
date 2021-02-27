package ru.dmkalvan.weatherapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.dmkalvan.weatherapp.data.Weather
import ru.dmkalvan.weatherapp.ui.WeatherCardFragment

/**
 * @author Dmitri Kalvan
 * @date 27.02.21
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, WeatherCardFragment.newInstance())
                    .commitAllowingStateLoss()
        }
    }

}