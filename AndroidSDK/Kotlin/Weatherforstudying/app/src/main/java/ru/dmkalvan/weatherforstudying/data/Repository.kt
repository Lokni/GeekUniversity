package ru.dmkalvan.weatherforstudying.data

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocal(): List<Weather>
}