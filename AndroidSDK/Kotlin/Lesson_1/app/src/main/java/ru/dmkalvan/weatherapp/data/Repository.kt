package ru.dmkalvan.weatherapp.data

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalDB(): Weather
}