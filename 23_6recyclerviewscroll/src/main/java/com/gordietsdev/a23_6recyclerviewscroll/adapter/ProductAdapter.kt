package com.gordietsdev.a23_6recyclerviewscroll.adapter

import com.gordietsdev.a23_6recyclerviewscroll.model.Item
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ProductAdapter() : ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
    }

    override fun setItems(items: List<Item>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}