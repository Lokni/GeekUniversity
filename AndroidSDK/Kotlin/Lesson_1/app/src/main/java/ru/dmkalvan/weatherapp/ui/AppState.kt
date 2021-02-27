package ru.dmkalvan.weatherapp.ui

import ru.dmkalvan.weatherapp.data.Weather

sealed class AppState {
    data class Success(val weatherData: Weather) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()

}