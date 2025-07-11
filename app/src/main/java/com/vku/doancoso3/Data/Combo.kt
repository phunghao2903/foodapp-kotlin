package com.vku.doancoso3.Data

import androidx.annotation.DrawableRes

data class Combo(
    @DrawableRes val image: Int,
    var category: String,
    val name: String,
    val star:Double,
)
