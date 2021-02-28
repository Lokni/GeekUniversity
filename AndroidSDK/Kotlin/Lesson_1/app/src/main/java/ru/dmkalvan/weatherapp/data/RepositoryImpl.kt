package ru.dmkalvan.weatherapp.data

class RepositoryImpl: Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalDB(): Weather {
        return Weather()
    }

    override fun size(): Int {
        return 25
    }
}