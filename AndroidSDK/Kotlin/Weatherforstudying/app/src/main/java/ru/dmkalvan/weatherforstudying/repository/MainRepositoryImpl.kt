package ru.dmkalvan.weatherforstudying.repository

import ru.dmkalvan.weatherforstudying.model.Weather
import ru.dmkalvan.weatherforstudying.model.getDefaultList

class MainRepositoryImpl : MainRepository {
    override fun getWeatherFromServer(): Weather = Weather()

    override fun getWeatherFromLocalStorage(): List<Weather> = getDefaultList()

}