package ru.dmkalvan.weatherforstudying.ui.weathercard

import android.os.Build
import androidx.annotation.RequiresApi
import ru.dmkalvan.weatherforstudying.data.WeatherDTO


@RequiresApi(Build.VERSION_CODES.N)
class WeatherLoader (private val listener: WeatherLoaderListener, private val city: String){



    interface WeatherLoaderListener {
        fun onLoaded(weatherDTO: WeatherDTO)
        fun onFailed(throwable: Throwable)
    }
}