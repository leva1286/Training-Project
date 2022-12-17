package com.gordietsdev.trainingproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val date: MutableList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.text)
        val icon = itemView.findViewById<ImageView>(R.id.icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = date[position]
        holder.icon.setImageResource(R.drawable.ic_launcher_foreground)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            payloads.find {
                it is String && it == "text"
            }.let { holder.text.text = date[position] }

            payloads.find {
                it is String && it == "icon"
            }.let { holder.icon.setImageResource(R.drawable.ic_launcher_background) }
        }
    }

    override fun getItemCount(): Int {
        return date.size
    }

    override fun getItemId(position: Int): Long {
        return date[position].hashCode().toLong()
    }
}