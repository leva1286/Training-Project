package com.gordietsdev.practiceadapterdelegates.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.skill_factory.unit5.adapter.AdDelegateAdapter
import com.skill_factory.unit5.adapter.ProductDelegateAdapter
import com.skill_factory.unit5.model.Item

class ProductAdapter() : ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
        delegatesManager.addDelegate(CountableDelegateAdapter())
    }
}