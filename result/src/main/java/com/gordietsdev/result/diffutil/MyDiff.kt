package com.gordietsdev.result.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gordietsdev.result.model.Ad
import com.gordietsdev.result.model.Item
import com.gordietsdev.result.model.Product

class MyDiff(val oldList: List<Item>, val newList: List<Item>) : DiffUtil.Callback() {
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
        return oldList[oldItemPosition] == newList[newItemPosition]
    }


}