package com.example.ppapb_p10_movieapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val duration: String,
    val rating: String,
    val genre: String,
    val synopsis: String
) : Parcelable
