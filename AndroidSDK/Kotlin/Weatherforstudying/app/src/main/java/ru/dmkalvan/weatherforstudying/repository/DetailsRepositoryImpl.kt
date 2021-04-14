package ru.dmkalvan.weatherforstudying.repository

import retrofit2.Callback
import ru.dmkalvan.weatherforstudying.model.WeatherDTO

class DetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource) : DetailsRepository {
    override fun getWeatherFromServer(city: String, callback: Callback<WeatherDTO>) {
        remoteDataSource.getWeatherDetails(city, callback)
    }


}