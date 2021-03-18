package ru.dmkalvan.weatherforstudying.repository

import ru.dmkalvan.weatherforstudying.model.WeatherDTO

interface DetailsRepository {
    fun getWeatherFromServer(city: String, callback: retrofit2.Callback<WeatherDTO>)
}