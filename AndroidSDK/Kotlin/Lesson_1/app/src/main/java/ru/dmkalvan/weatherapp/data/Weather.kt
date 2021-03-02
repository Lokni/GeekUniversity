package ru.dmkalvan.weatherapp.data

data class Weather(
        val city: City = getDefaultCity(),
        val weather: String? = "Clear",
        val temperature: Int? = 25,
        val minimalTemp: Int? = 23,
        val maximalTemp: Int? = 27,
        val sunrise: Double? = 5.45,
        val sunset: Double? = 22.30,
        val chanceOfPrecipitation: Int? = 0,
        val feelsLike: Int? = 26,
        val humidity: Int? = 15,
        val wind: String? = "SE",
        val precipitation: Double? = 0.0,
        val pressure: Int? = 1005,
        val visibility: Int? = 15,
        val uvIndex: Int? = 1
)

fun getDefaultCity() = City("Mountain View", 37.386051, -122.083855)