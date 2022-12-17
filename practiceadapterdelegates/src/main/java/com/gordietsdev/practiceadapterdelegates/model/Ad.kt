package com.skill_factory.unit5.model

class Ad(val title: String, val content : String, private val id : Int) : Item {
    override fun getId(): Int {
        return id
    }
}