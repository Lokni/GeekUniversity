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
            Weather(City("Mountain View", 37.386051, -122.083855),23, 5),
            Weather(City("London", 51.5085300, -0.1257400), 1, 2),
            Weather(City("Tokyo", 35.6895000, 139.6917100), 3, 4),
            Weather(City("Paris", 48.8534100, 2.3488000), 5, 6),
            Weather(City("Berlin", 52.52000659999999, 13.404953999999975), 7, 8),
            Weather(City("Rome", 41.9027835, 12.496365500000024), 9, 10),
            Weather(City("Minsk", 53.90453979999999, 27.561524400000053), 11, 12),
            Weather(City("Istanbul", 41.0082376, 28.97835889999999), 13, 14),
            Weather(City("Washington", 38.9071923, -77.03687070000001), 15, 16),
            Weather(City("Beijing", 39.90419989999999, 116.40739630000007), 19, 20)

}