package ru.dmkalvan.weatherapp.data

class ForecastImpl: Forecast {
    override fun getDailyForecast(): List<DailyForecast> {
        return getDailyForecast()
    }

    override fun getHourlyForecast(): List<HourlyForecast> {
        return getHourlyForecast()
    }

}