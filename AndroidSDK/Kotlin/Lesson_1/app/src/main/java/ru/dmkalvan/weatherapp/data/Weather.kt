package ru.dmkalvan.weatherapp.data

data class Weather(
        var city: City = getDefaultCity(),
        var temperature: Int? = null,
        var minimalTemp: Int? = null,
        var maximalTemp: Int? = null,
        var sunrise: Long? = null,
        var sunset: Long? = null,
        var chanceOfPrecipitation: Int? = null,
        var feelsLike: Int? = null,
        var humidity: Int? = null,
        var wind: String? = null,
        var precipitation: Float? = null,
        var pressure: Int? = null,
        var visibility: Int? = null,
        var uvIndex: Int? = null
)

fun getDefaultCity() = City ("Mountain View", 37.386051, -122.083855)