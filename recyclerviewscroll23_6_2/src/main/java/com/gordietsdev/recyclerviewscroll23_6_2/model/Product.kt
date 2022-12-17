package com.gordietsdev.recyclerviewscroll23_6_2.model

import androidx.annotation.DrawableRes

class Product(var id: Int, @DrawableRes val idIcon: Int, val name: String, val desc: String) : Item