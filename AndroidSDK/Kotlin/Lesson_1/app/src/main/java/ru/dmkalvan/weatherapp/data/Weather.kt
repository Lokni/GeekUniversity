package ru.dmkalvan.weatherapp.data

import ru.dmkalvan.weatherapp.R

data class Weather(
        var city: City = getDefaultCity(),
        var weather: String? = R.string.clear.toString(),
        var temperature: Int? = 25,
        var minimalTemp: Int? = 23,
        var maximalTemp: Int? = 27,
        var sunrise: Double? = 5.45,
        var sunset: Double? = 22.30,
        var chanceOfPrecipitation: Int? = 0,
        var feelsLike: Int? = 26,
        var humidity: Int? = 15,
        var wind: String? = R.string.east.toString() + R.string.south,
        var precipitation: Double? = 0.0,
        var pressure: Int? = 1005,
        var visibility: Int? = 15,
        var uvIndex: Int? = 1
)

fun getDefaultCity() = City("Mountain View", 37.386051, -122.083855)