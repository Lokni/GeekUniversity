package ru.dmkalvan.weatherforstudying.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dmkalvan.weatherforstudying.app.App.Companion.getHistoryDao
import ru.dmkalvan.weatherforstudying.app.AppState
import ru.dmkalvan.weatherforstudying.model.Weather
import ru.dmkalvan.weatherforstudying.repository.DetailsRepository
import ru.dmkalvan.weatherforstudying.repository.DetailsRepositoryImpl
import ru.dmkalvan.weatherforstudying.repository.LocalRepositoryImpl
import ru.dmkalvan.weatherforstudying.repository.RemoteDataSource

class DetailsViewModel(
    val detailLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val detailsRepositoryImpl: DetailsRepository = DetailsRepositoryImpl(RemoteDataSource()),
    private val historyRepositoryImpl: LocalRepositoryImpl = LocalRepositoryImpl(getHistoryDao())
) : ViewModel() {

    fun getWeatherFromRemoteSource(city: String) {
        TODO("Not yet implemented")
    }

    fun saveCityToDB(weather: Weather) {
        TODO("Not yet implemented")
    }
}
