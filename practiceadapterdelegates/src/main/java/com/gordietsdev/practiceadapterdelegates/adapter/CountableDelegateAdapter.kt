package com.gordietsdev.practiceadapterdelegates.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gordietsdev.practiceadapterdelegates.R
import com.gordietsdev.practiceadapterdelegates.model.Countable
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.skill_factory.unit5.model.Item

class CountableDelegateAdapter() : AbsListItemAdapterDelegate<Countable, Item, CountableDelegateAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val count = itemView.findViewById<TextView>(R.id.count)
        val name = itemView.findViewById<TextView>(R.id.text_name)
        val desc = itemView.findViewById<TextView>(R.id.text_desc)

    }

    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is Countable
    }

    override fun onCreateViewHolder(parent: ViewGroup): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.countable_item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(item: Countable, holder: MyHolder, payloads: MutableList<Any>) {
        holder.count.text = item.count.toString()
        holder.desc.text = item.desc
        holder.name.text = item.name
        holder.icon.setImageResource(item.icon)
    }
}