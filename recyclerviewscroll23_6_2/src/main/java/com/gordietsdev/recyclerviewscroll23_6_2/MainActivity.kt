package com.gordietsdev.recyclerviewscroll23_6_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gordietsdev.recyclerviewscroll23_6_2.adapter.ProductAdapter
import com.gordietsdev.recyclerviewscroll23_6_2.diff.MyDiff
import com.gordietsdev.recyclerviewscroll23_6_2.model.Ad
import com.gordietsdev.recyclerviewscroll23_6_2.model.Item
import com.gordietsdev.recyclerviewscroll23_6_2.model.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = ProductAdapter()
        val list1 = arrayListOf(
            Ad(0, "Акция", "Скидка на бананы 15%"),
            Product(
                1,
                R.drawable.ic_apple,
                "Apple",
                "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
            ),
            Product(
                2,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                3,
                R.drawable.ic_lemon,
                "Lemon",
                "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
            ),
            Product(
                4,
                R.drawable.ic_pear,
                "Pear",
                "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
            ),
            Product(
                5,
                R.drawable.ic_strawberry,
                "Strawberry",
                "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."
            ),
            Product(
                6,
                R.drawable.ic_orange,
                "Orange",
                "Orange juice is widely used as a drink in restaurants and cafes."
            ),
            Product(
                7,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                8,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                9,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                10,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                11,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                12,
                R.drawable.ic_lemon,
                "Lemon",
                "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
            ),
            Product(
                13,
                R.drawable.ic_lemon,
                "Lemon",
                "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
            ),
            Product(
                14,
                R.drawable.ic_lemon,
                "Lemon",
                "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
            ),

            )

        adapter.items = list1
        recyclerView.adapter = adapter

        var isLoading = false

        fun updateItems(newList: ArrayList<Item>) {
            val diff = MyDiff(adapter.items as ArrayList<Item>, newList)
            val diffResult = DiffUtil.calculateDiff(diff)
            adapter.items = newList
            diffResult.dispatchUpdatesTo(adapter)
            isLoading = false
        }

        val scrollListener = object : RecyclerView.OnScrollListener() {
            @Override
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val recyclerManager = recyclerView.layoutManager as RecyclerView.LayoutManager
                val visibleItemCount = recyclerManager.childCount
                val totalItemCount = recyclerManager.itemCount
                val firstVisibleItems =
                    (recyclerManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (!isLoading) {
                    if (visibleItemCount + firstVisibleItems >= totalItemCount) {
                        isLoading = true
                        val newList = arrayListOf<Item>()
                        newList.addAll(adapter.items)
                        newList.addAll(list1)
                        for ((id, i) in newList.withIndex()) {
                            if (i is Product) {
                                i.id = id
                            } else if (i is Ad) {
                                i.id = id
                            }
                        }
                        updateItems(newList)
                    }
                }
            }
        }

        recyclerView.addOnScrollListener(scrollListener)
    }
}

