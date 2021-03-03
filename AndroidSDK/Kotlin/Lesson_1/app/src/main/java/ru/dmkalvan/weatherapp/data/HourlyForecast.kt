package ru.dmkalvan.weatherapp.data

import ru.dmkalvan.weatherapp.R

data class HourlyForecast(
        val temperature: Int = 21,
        val hour: Int = 0,
        val icon: Int = R.drawable.ic_launcher_foreground
)

fun getHourlyForecast(): List<HourlyForecast> {
    return listOf(
            HourlyForecast(18, 0, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 1, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 2, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 3, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 4, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 5, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 6, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 7, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 8, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 9, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 10, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 11, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 12, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 13, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 14, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 15, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 16, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 17, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 18, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 19, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 20, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 21, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 22, R.drawable.ic_launcher_foreground),
            HourlyForecast(18, 23, R.drawable.ic_launcher_foreground)
    )
}