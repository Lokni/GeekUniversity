package ru.dmkalvan.weatherapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dmkalvan.weatherapp.data.*
import java.lang.Thread.sleep

class MainViewModel(
        private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
        private val repositoryImpl: Repository = RepositoryImpl(),
private val hourlyForecast: Forecast = ForecastImpl(),
private val dailyForecast: Forecast = ForecastImpl()) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(300)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocalDB(),
                    dailyForecast.getDailyForecast(),
                    hourlyForecast.getHourlyForecast()))
        }.start()
    }

}