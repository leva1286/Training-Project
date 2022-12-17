package com.gordietsdev.practiceadapterdelegates.model

import android.content.Intent
import androidx.annotation.DrawableRes
import com.skill_factory.unit5.model.Item

data class Countable(@DrawableRes val icon : Int, val count : Int, val name : String, val desc : String, private val id: Int) : Item {
    override fun getId(): Int {
        return id
    }
}