package ru.dmkalvan.weatherapp.ui

import ru.dmkalvan.weatherapp.data.DailyForecast
import ru.dmkalvan.weatherapp.data.HourlyForecast
import ru.dmkalvan.weatherapp.data.Weather

sealed class AppState {
    data class Success(val weatherData: List<Weather>,
                       val dailyWeatherData: List<DailyForecast>,
                       val hourlyWeatherData: List<HourlyForecast>
    ) : AppState()

    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()

}