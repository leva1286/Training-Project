package com.gordietsdev.practicediffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var data: ArrayList<Num>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    inner class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val num = itemView.findViewById<TextView>(R.id.num)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.num.text = data[position].num.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return data[position].hashCode().toLong()
    }
}