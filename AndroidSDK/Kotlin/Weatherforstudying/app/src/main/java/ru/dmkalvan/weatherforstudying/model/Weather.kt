package ru.dmkalvan.weatherforstudying.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 23,
    val feelsLike: Int = 25,
    val conditions: String = "Sunny",
val icon: String = "01d"
) : Parcelable

fun getDefaultCity(): City {
    return City("Mountain View")
}

fun getDefaultList(): List<Weather>{
    return listOf(
        Weather(City("Mountain View"), 23, 25),
        Weather(City("Cupertino"), 26, 27),
        Weather(City("Tokyo"), 26, 27),
        Weather(City("Moscow"), 26, 27),
        Weather(City("Beijing"), 26, 27),
    )
}


