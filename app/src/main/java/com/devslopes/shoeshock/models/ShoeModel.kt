package com.devslopes.shoeshock.models

import android.media.Image

data class ShoeModel(
    val id: Long,
    val brand: String,
    val title: String,
    val image: Int,
    val description: String,
    val price: Double,
    val sizeMap: MutableList<Double>
)


