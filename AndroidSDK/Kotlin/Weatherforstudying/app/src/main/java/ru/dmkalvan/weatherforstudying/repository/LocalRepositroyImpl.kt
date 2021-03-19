package ru.dmkalvan.weatherforstudying.repository

import ru.dmkalvan.weatherforstudying.model.Weather
import ru.dmkalvan.weatherforstudying.room.HistoryDao

class LocalRepositroyImpl(private val localDataSource: HistoryDao): LocalRepository {
    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        localDataSource.insert(convertWeatherToEntity(weather))
    }
}