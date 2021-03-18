package ru.dmkalvan.weatherforstudying.repository

import ru.dmkalvan.weatherforstudying.model.Weather

interface MainRepository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): List<Weather>
}