package ru.dmkalvan.weatherforstudying.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dmkalvan.weatherforstudying.data.Repository
import ru.dmkalvan.weatherforstudying.data.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(500)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocal()))
        }.start()

    }
}