package com.gordietsdev.recyclerviewscroll23_6_2.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.gordietsdev.recyclerviewscroll23_6_2.model.Item

class ProductAdapter() : ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
    }
}