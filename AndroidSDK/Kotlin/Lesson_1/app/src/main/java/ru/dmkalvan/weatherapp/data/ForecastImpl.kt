package ru.dmkalvan.weatherapp.data

import ru.dmkalvan.weatherapp.R
import java.time.DayOfWeek

class ForecastImpl : Forecast {
    override fun getDailyData(): List<DailyForecast> {
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

    override fun getHourlyData(): List<HourlyForecast> {
        return listOf(
                HourlyForecast(18, 0, R.drawable.ic_launcher_foreground),
                HourlyForecast(19, 1, R.drawable.ic_launcher_foreground),
                HourlyForecast(20, 2, R.drawable.ic_launcher_foreground),
                HourlyForecast(20, 3, R.drawable.ic_launcher_foreground),
                HourlyForecast(23, 4, R.drawable.ic_launcher_foreground),
                HourlyForecast(24, 5, R.drawable.ic_launcher_foreground),
                HourlyForecast(25, 6, R.drawable.ic_launcher_foreground),
                HourlyForecast(25, 7, R.drawable.ic_launcher_foreground),
                HourlyForecast(25, 8, R.drawable.ic_launcher_foreground),
                HourlyForecast(25, 9, R.drawable.ic_launcher_foreground),
                HourlyForecast(27, 10, R.drawable.ic_launcher_foreground),
                HourlyForecast(27, 11, R.drawable.ic_launcher_foreground),
                HourlyForecast(24, 12, R.drawable.ic_launcher_foreground),
                HourlyForecast(26, 13, R.drawable.ic_launcher_foreground),
                HourlyForecast(28, 14, R.drawable.ic_launcher_foreground),
                HourlyForecast(27, 15, R.drawable.ic_launcher_foreground),
                HourlyForecast(26, 16, R.drawable.ic_launcher_foreground),
                HourlyForecast(26, 17, R.drawable.ic_launcher_foreground),
                HourlyForecast(26, 18, R.drawable.ic_launcher_foreground),
                HourlyForecast(26, 19, R.drawable.ic_launcher_foreground),
                HourlyForecast(24, 20, R.drawable.ic_launcher_foreground),
                HourlyForecast(23, 21, R.drawable.ic_launcher_foreground),
                HourlyForecast(22, 22, R.drawable.ic_launcher_foreground),
                HourlyForecast(19, 23, R.drawable.ic_launcher_foreground)
        )
    }

}