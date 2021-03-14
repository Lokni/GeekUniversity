package ru.dmkalvan.weatherforstudying.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.dmkalvan.weatherforstudying.R
import ru.dmkalvan.weatherforstudying.databinding.ActivityMainBinding
import ru.dmkalvan.weatherforstudying.ui.citylist.CityListFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CityListFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }
}