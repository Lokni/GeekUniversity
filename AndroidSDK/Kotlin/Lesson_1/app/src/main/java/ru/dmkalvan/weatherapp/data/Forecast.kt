package ru.dmkalvan.weatherapp.data

interface Forecast {
    fun getDailyForecast(): List<DailyForecast>
    fun getHourlyForecast(): List<HourlyForecast>
}