package ru.dmkalvan.weatherapp.data

class RepositoryImpl: Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalDB(): List<Weather> {
        return
    }

}