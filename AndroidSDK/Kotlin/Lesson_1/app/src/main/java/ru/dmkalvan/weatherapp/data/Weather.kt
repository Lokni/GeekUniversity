package ru.dmkalvan.weatherapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Weather(
        val city: City = getDefaultCity(),
        val weather: String? = "Clear",
        val temperature: Int? = 25,
        val minimalTemp: Int? = 23,
        val maximalTemp: Int? = 27,
        val sunrise: Double? = 5.45,
        val sunset: Double? = 22.30,
        val chanceOfPrecipitation: Int? = 0,
        val feelsLike: Int? = 26,
        val humidity: Int? = 15,
        val wind: String? = "SE",
        val precipitation: Double? = 0.0,
        val pressure: Int? = 1005,
        val visibility: Int? = 15,
        val uvIndex: Int? = 1
): Parcelable

fun getDefaultCity() = City("Mountain View", 37.386051, -122.083855)

fun getCitiesList(): List<Weather> {
    return listOf(
            Weather(City("Mountain View", 37.386051, -122.083855),
                    "Clear",
                    25,
            23,
            27,
            5.45,
            22.30,
            0,
            26,
            15,
            "SE",
            0.0,
            1005,
            15,
            1),
            Weather(City("London", 51.5085300, -0.1257400), "Rain",
            18,
            19,
            16,
            6.00,
            22.00,
            100,
                    20,
                    100,
                    "N",
                    5.0,
                    865,
                    2,
                    0
            ),
            Weather(City("Tokyo", 35.6895000, 139.6917100), "Cloudy",
                    21,
                    20,
            25,
            5.30,
            21.55,
            25,
            24,
            83,
            "W",
            2.5,
            975,
            5,
            1)
    )

}