package com.gordietsdev.result.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gordietsdev.result.diffutil.MyDiff
import com.gordietsdev.result.model.Item
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ProductAdapter() : ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
    }

    override fun setItems(items: List<Item>?) {
        if (this.items == null) {
            super.setItems(items)
        }
        val myDiff = MyDiff(this.items as ArrayList<Item>, items as ArrayList<Item>)
        val diffResult = DiffUtil.calculateDiff(myDiff)
        this.items = items
        diffResult.dispatchUpdatesTo(this)
    }
}