package ru.dmkalvan.weatherapp.data

import ru.dmkalvan.weatherapp.R
import java.time.DayOfWeek

data class DailyForecast(
        val dayOfWeek: DayOfWeek = DayOfWeek.MONDAY,
        val tempMinimum: Int = 20,
        val tempMaximum: Int = 30,
        val icon: Int = R.drawable.ic_launcher_foreground
)
