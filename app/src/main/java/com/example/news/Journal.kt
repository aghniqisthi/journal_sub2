package com.example.news

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Journal(
    val title: String,
    val volume: String,
    val desc: String,
    val link: String,
    val image: Int
    ): Parcelable
