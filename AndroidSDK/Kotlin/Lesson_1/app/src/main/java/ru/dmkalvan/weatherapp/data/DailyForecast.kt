package ru.dmkalvan.weatherapp.data

import ru.dmkalvan.weatherapp.R
import java.time.DayOfWeek

data class DailyForecast(
        val dayOfWeek: DayOfWeek = DayOfWeek.MONDAY,
        val tempMinimum: Int = 20,
        val tempMaximum: Int = 30,
        val icon: Int = R.drawable.ic_launcher_foreground
)

fun getDailyForecast(): List<DailyForecast> {
    return listOf(
            DailyForecast(DayOfWeek.MONDAY, 21, 25, R.drawable.ic_launcher_foreground),
            DailyForecast(DayOfWeek.TUESDAY, 20, 22, R.drawable.ic_launcher_foreground),
            DailyForecast(DayOfWeek.WEDNESDAY, 22, 24, R.drawable.ic_launcher_foreground),
            DailyForecast(DayOfWeek.THURSDAY, 23, 28, R.drawable.ic_launcher_foreground),
            DailyForecast(DayOfWeek.FRIDAY, 25, 27, R.drawable.ic_launcher_foreground),
            DailyForecast(DayOfWeek.SATURDAY, 28, 31, R.drawable.ic_launcher_foreground),
            DailyForecast(DayOfWeek.SUNDAY, 27, 30, R.drawable.ic_launcher_foreground)
    )
}
