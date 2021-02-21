package ru.dmkalvan.weatherapp.data

import ru.dmkalvan.weatherapp.ui.WeatherViewHolder

object Repository {

    private val weatherList: List<Weather>

    init {
        weatherList = listOf(Weather("Moscow", 20), Weather("Berlin", 25))
    }

    fun getWeatherList(): List<Weather>{
        return weatherList
    }

    fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    fun getItemCount() = weatherList.size
}