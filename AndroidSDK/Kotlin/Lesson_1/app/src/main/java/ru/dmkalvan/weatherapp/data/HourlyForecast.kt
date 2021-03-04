package ru.dmkalvan.weatherapp.data

import ru.dmkalvan.weatherapp.R

data class HourlyForecast(
        val temperature: Int = 21,
        val hour: Int = 0,
        val icon: Int = R.drawable.ic_launcher_foreground
)