package ru.dmkalvan.weatherforstudying.model

data class WeatherDTO(
    val fact: FactDTO?
)

data class FactDTO(
    val temperature: Int?,
    val feelsLike: Int?,
    val conditions: String?,
    val icon: String?
)
