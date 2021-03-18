package ru.dmkalvan.weatherapp.data

data class WeatherDTO(
        val fact: FactDTO?
)

data class FactDTO(
        val city: City?,
        val weather: String?,
        val temperature: Int?,
        val minimalTemp: Int?,
        val maximalTemp: Int?,
        val sunrise: Double?,
        val sunset: Double?,
        val chanceOfPrecipitation: Int?,
        val feelsLike: Int?,
        val humidity: Int?,
        val wind: String?,
        val precipitation: Double?,
        val pressure: Int?,
        val visibility: Int?,
        val uvIndex: Int?
)