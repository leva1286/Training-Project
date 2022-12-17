package com.gordietsdev.mydiffutil

import androidx.annotation.DrawableRes

data class Product(val id : Int, @DrawableRes val idIcon : Int, val name : String, val desc: String)
