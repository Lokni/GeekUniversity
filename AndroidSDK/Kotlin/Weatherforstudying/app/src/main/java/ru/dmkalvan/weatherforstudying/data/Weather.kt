package ru.dmkalvan.weatherforstudying.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 23,
    val feelsLike: Int = 25
) : Parcelable

fun getDefaultCity(): City {
    return City("Mountain View")
}


