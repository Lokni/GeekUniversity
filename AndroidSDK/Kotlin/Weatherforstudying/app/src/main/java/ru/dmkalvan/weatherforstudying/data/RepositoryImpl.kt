package ru.dmkalvan.weatherforstudying.data

class RepositoryImpl : Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocal(): List<Weather> {
        return getDefaultList()
    }
}