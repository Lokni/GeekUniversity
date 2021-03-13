package ru.dmkalvan.weatherforstudying.data

data class WeatherDTO(
    val fact: FactDTO?
)

data class FactDTO(
    val temperature: Int?,
    val feelsLike: Int?,
    val conditions: String?
)
