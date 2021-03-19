package ru.dmkalvan.weatherforstudying.repository

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.dmkalvan.weatherforstudying.BuildConfig
import ru.dmkalvan.weatherforstudying.model.WeatherDTO

class RemoteDataSource {

    private val weatherApi = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .client(createOkHttpClient(WeatherApiInterceptor()))
        .build().create(WeatherAPI::class.java)

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }


    fun getWeatherDetails(city: String, callback: Callback<WeatherDTO>) {
        weatherApi.getWeather(BuildConfig.WEATHER_API_KEY, city).enqueue(callback)
    }

    inner class WeatherApiInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return chain.proceed(chain.request())
        }

    }
}


