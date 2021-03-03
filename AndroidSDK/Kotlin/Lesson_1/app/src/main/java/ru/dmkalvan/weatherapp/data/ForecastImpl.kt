package ru.dmkalvan.weatherapp.data

class ForecastImpl : Forecast {
    override fun getDailyData(): List<DailyForecast> {
        return getDailyForecast()
    }

    override fun getHourlyData(): List<HourlyForecast> {
        return getHourlyForecast()
    }

}