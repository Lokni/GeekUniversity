package ru.dmkalvan.weatherforstudying.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class City(
    val city: String
) : Parcelable
