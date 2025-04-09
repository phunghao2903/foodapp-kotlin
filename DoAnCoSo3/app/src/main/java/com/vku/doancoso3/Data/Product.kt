package com.example.foodapp.Data

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product(
    val id: Int,
    @DrawableRes val image: Int,
    var category: String,
    val name: String,
    val star:Double,
)


