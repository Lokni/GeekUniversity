package ru.dmkalvan.weatherapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dmkalvan.weatherapp.data.Repository
import ru.dmkalvan.weatherapp.data.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
        private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
        private val repositoryImpl: Repository = RepositoryImpl()) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(300)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocalDB()))
        }.start()
    }

}