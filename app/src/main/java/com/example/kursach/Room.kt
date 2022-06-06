package com.example.kursach

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Room (
    val id :Int,
    val imageRes : Int,
    val clientsCount : Int,
    val roomName : String
) : Parcelable