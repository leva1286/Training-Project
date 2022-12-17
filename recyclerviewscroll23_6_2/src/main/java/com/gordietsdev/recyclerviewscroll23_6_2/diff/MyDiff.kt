package com.gordietsdev.recyclerviewscroll23_6_2.diff

import androidx.recyclerview.widget.DiffUtil
import com.gordietsdev.recyclerviewscroll23_6_2.model.Ad
import com.gordietsdev.recyclerviewscroll23_6_2.model.Item
import com.gordietsdev.recyclerviewscroll23_6_2.model.Product

class MyDiff(val oldList: ArrayList<Item>, val newList: ArrayList<Item>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (oldList[oldItemPosition] is Ad && newList[newItemPosition] is Ad) {
            (oldList[oldItemPosition] as Ad).id == (newList[newItemPosition] as Ad).id
        } else if (oldList[oldItemPosition] is Product && newList[newItemPosition] is Product) {
            (oldList[oldItemPosition] as Product).id == (newList[newItemPosition] as Product).id
        } else {
            false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (oldList[oldItemPosition] is Ad && newList[newItemPosition] is Ad) {
            (oldList[oldItemPosition] as Ad).title == (newList[newItemPosition] as Ad).title &&
                    (oldList[oldItemPosition] as Ad).content == (newList[newItemPosition] as Ad).content

        } else if (oldList[oldItemPosition] is Product && newList[newItemPosition] is Product) {
            (oldList[oldItemPosition] as Product).idIcon == (newList[newItemPosition] as Product).idIcon &&
                    (oldList[oldItemPosition] as Product).name == (newList[newItemPosition] as Product).name &&
                    (oldList[oldItemPosition] as Product).desc == (newList[newItemPosition] as Product).desc

        } else {
            false
        }
    }
}