package com.gordietsdev.adapterdelegates


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ProductDelegateAdapter() :
    AbsListItemAdapterDelegate<Product, Item, ProductDelegateAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val name = itemView.findViewById<TextView>(R.id.text_name)
        val desc = itemView.findViewById<TextView>(R.id.text_desc)
    }

    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is Product
    }

    override fun onCreateViewHolder(parent: ViewGroup): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(item: Product, holder: MyHolder, payloads: MutableList<Any>) {
        holder.icon.setImageResource(item.idIcon)
        holder.name.text = item.name
        holder.desc.text = item.desc
    }

}