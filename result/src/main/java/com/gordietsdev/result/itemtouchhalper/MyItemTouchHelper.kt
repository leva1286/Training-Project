package com.gordietsdev.result.itemtouchhalper

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.gordietsdev.result.adapter.ProductAdapter
import com.gordietsdev.result.diffutil.MyDiff
import com.gordietsdev.result.model.Item

class MyItemTouchHelper(private val adapter: ProductAdapter) : ItemTouchHelper.Callback() {

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val swipeFlags = ItemTouchHelper.END
        return makeMovementFlags(0, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val newList = arrayListOf<Item>()
        newList.addAll(adapter.items)
        newList.removeAt(viewHolder.absoluteAdapterPosition)
        val myDiff = MyDiff(adapter.items, newList)
        val diffResult = DiffUtil.calculateDiff(myDiff)
        adapter.items = newList
        diffResult.dispatchUpdatesTo(adapter)
    }
}