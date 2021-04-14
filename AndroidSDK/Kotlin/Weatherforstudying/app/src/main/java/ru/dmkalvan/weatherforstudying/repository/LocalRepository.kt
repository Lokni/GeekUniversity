package ru.dmkalvan.weatherforstudying.repository

import ru.dmkalvan.weatherforstudying.model.Weather

interface LocalRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}