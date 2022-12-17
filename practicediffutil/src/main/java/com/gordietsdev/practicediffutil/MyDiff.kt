package com.gordietsdev.practicediffutil

import androidx.recyclerview.widget.DiffUtil

class MyDiff(val oldList: ArrayList<Num>, val newList: ArrayList<Num>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].num == newList[newItemPosition].num
    }

}