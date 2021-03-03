package ru.dmkalvan.weatherapp.data

interface Forecast {
    fun getDailyData(): List<DailyForecast>
    fun getHourlyData(): List<HourlyForecast>
}