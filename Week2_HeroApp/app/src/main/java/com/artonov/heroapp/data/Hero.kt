package com.artonov.heroapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var nama: String,
    var description: String,
    var photo: Int
) : Parcelable
