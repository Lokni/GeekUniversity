package ru.dmkalvan.weatherforstudying.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dmkalvan.weatherforstudying.app.App.Companion.getHistoryDao
import ru.dmkalvan.weatherforstudying.app.AppState
import ru.dmkalvan.weatherforstudying.repository.LocalRepositoryImpl

class HistoryViewModel (
    val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val historyRepositoryImpl: LocalRepositoryImpl = LocalRepositoryImpl(getHistoryDao())
) : ViewModel() {

    fun getAllHistory() {
        historyLiveData.value = AppState.Loading
        historyLiveData.value = AppState.Success(historyRepositoryImpl.getAllHistory())
    }
}
