package ru.dmkalvan.weatherforstudying.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class City(
    val city: String
) : Parcelable
