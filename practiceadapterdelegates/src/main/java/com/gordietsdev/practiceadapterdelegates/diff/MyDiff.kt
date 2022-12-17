package com.gordietsdev.practiceadapterdelegates.diff

import androidx.recyclerview.widget.DiffUtil
import com.gordietsdev.practiceadapterdelegates.model.Countable
import com.skill_factory.unit5.model.Ad
import com.skill_factory.unit5.model.Item
import com.skill_factory.unit5.model.Product

class MyDiff(val oldList : ArrayList<Item>,val newList: ArrayList<Item>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].getId() == newList[newItemPosition].getId()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if (oldList[oldItemPosition] is Product && newList[newItemPosition] is Product) {
            return (oldList[oldItemPosition] as Product).idIcon == (newList[newItemPosition] as Product).idIcon &&
                    (oldList[oldItemPosition] as Product).desc == (newList[newItemPosition] as Product).desc &&
                    (oldList[oldItemPosition] as Product).name == (newList[newItemPosition] as Product).name

        } else if (oldList[oldItemPosition] is Ad && newList[newItemPosition] is Ad) {
            return (oldList[oldItemPosition] as Ad).title == (newList[newItemPosition] as Ad).title &&
                    (oldList[oldItemPosition] as Ad).content == (newList[newItemPosition] as Ad).content

        } else if (oldList[oldItemPosition] is Countable && newList[newItemPosition] is Countable) {
            return (oldList[oldItemPosition] as Countable).icon == (newList[newItemPosition] as Countable).icon &&
                    (oldList[oldItemPosition] as Countable).count == (newList[newItemPosition] as Countable).count &&
                    (oldList[oldItemPosition] as Countable).name == (newList[newItemPosition] as Countable).name &&
                    (oldList[oldItemPosition] as Countable).desc == (newList[newItemPosition] as Countable).desc

        } else {
            return false
        }
    }
}