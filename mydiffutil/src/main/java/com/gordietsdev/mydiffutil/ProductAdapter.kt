package com.gordietsdev.mydiffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var data : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    inner class ProductHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val name = itemView.findViewById<TextView>(R.id.text_name)
        val desc = itemView.findViewById<TextView>(R.id.text_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.icon.setImageResource(data[position].idIcon)
        holder.name.text = data[position].name
        holder.desc.text = data[position].desc
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return data[position].hashCode().toLong()
    }

}