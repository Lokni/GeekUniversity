package ru.dmkalvan.weatherforstudying.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.dmkalvan.weatherforstudying.model.WeatherDTO

interface WeatherAPI {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") api_key: String

    ): Call<WeatherDTO>
}