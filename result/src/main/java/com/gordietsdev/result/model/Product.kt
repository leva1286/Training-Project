package com.gordietsdev.result.model

import androidx.annotation.DrawableRes

class Product(override val id: Int, @DrawableRes val idIcon: Int, val name: String, val desc: String) : Item