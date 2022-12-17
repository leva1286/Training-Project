package com.skill_factory.unit5.model

import androidx.annotation.DrawableRes
class Product(private val id: Int, @DrawableRes val idIcon: Int, val name: String, val desc: String) : Item {
    override fun getId(): Int {
        return id
    }
}