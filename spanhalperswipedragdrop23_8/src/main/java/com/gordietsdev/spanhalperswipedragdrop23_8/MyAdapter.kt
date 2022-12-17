package com.gordietsdev.spanhalperswipedragdrop23_8

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    val colors = arrayListOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.WHITE)

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textView.text = "${position + 1}"
        holder.itemView.setBackgroundColor(colors[position])
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}