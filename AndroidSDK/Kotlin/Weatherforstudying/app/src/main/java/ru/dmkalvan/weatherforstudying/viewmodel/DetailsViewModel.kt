package ru.dmkalvan.weatherforstudying.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.dmkalvan.weatherforstudying.app.App.Companion.getHistoryDao
import ru.dmkalvan.weatherforstudying.app.AppState
import ru.dmkalvan.weatherforstudying.model.Weather
import ru.dmkalvan.weatherforstudying.model.WeatherDTO
import ru.dmkalvan.weatherforstudying.repository.DetailsRepository
import ru.dmkalvan.weatherforstudying.repository.DetailsRepositoryImpl
import ru.dmkalvan.weatherforstudying.repository.LocalRepositoryImpl
import ru.dmkalvan.weatherforstudying.repository.RemoteDataSource
import ru.dmkalvan.weatherforstudying.utils.convertDtoToModel

private const val SERVER_ERROR = "Ошибка сервера"
private const val REQUEST_ERROR = "Ошибка запроса на сервер"
private const val CORRUPTED_DATA = "Неполные данные"

class DetailsViewModel(
    val detailsLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val detailsRepositoryImpl: DetailsRepository = DetailsRepositoryImpl(RemoteDataSource()),
    private val historyRepositoryImpl: LocalRepositoryImpl = LocalRepositoryImpl(getHistoryDao())
) : ViewModel() {

    fun getWeatherFromRemoteSource(city: String) {
        detailsLiveData.value = AppState.Loading
        detailsRepositoryImpl.getWeatherFromServer(city, callBack)
    }

    fun saveCityToDB(weather: Weather) {
        historyRepositoryImpl.saveEntity(weather)
    }

    private val callBack = object :
        Callback<WeatherDTO> {

        override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
            val serverResponse: WeatherDTO? = response.body()
            detailsLiveData.postValue(
                if (response.isSuccessful && serverResponse != null) {
                    checkResponse(serverResponse)
                } else {
                    AppState.Error(Throwable(SERVER_ERROR))
                }
            )
        }

        override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
            detailsLiveData.postValue(AppState.Error(Throwable(t.message ?: REQUEST_ERROR)))
        }

        private fun checkResponse(serverResponse: WeatherDTO): AppState {
            val fact = serverResponse.fact
            return if (fact?.temperature == null || fact.feelsLike == null || fact.conditions.isNullOrEmpty()) {
                AppState.Error(Throwable(CORRUPTED_DATA))
            } else {
                AppState.Success(convertDtoToModel(serverResponse))
            }
        }
    }
}
