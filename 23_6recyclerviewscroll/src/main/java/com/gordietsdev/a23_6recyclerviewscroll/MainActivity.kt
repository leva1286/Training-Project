package com.gordietsdev.a23_6recyclerviewscroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gordietsdev.a23_6recyclerviewscroll.adapter.ProductAdapter
import com.gordietsdev.a23_6recyclerviewscroll.model.Ad
import com.gordietsdev.a23_6recyclerviewscroll.model.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = ProductAdapter()
        adapter.items = arrayListOf(
            Product(
                0,
                R.drawable.ic_apple,
                "Apple",
                "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
            ),
            Ad("Акция", "Скидка на бананы 15%"),
            Product(
                1,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                2,
                R.drawable.ic_lemon,
                "Lemon",
                "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
            ),
            Product(
                3,
                R.drawable.ic_pear,
                "Pear",
                "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
            ),
            Product(
                4,
                R.drawable.ic_strawberry,
                "Strawberry",
                "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."
            ),
            Product(
                5,
                R.drawable.ic_orange,
                "Orange",
                "Orange juice is widely used as a drink in restaurants and cafes."
            ),
            Product(
                6,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
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
                R.drawable.ic_lemon,
                "Lemon",
                "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
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

            )
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.adapter = adapter
        var savePositionFirst = 0
        var savePositionLast = 0

        //Метод который сохраняет текущую позицию скрола
        fun savePosition() {
            savePositionFirst = layoutManager.findFirstVisibleItemPosition()
            savePositionLast = layoutManager.findLastVisibleItemPosition()

        }

        //Метод который скролит список к началу
        fun scrollToStart() {
            recyclerView.smoothScrollToPosition(0)
        }

        //Скролит к savePositionFirst
        fun scrollToSaveStartPosition() {
            recyclerView.smoothScrollToPosition(savePositionFirst)
        }

        //Скролит к savePositionLast
        fun scrollToSaveLastPosition() {
            recyclerView.smoothScrollToPosition(savePositionLast)
        }

        //Метод который скролит список в конец
        fun scrollToEnd() {
            recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
        }

        val up = findViewById<ImageView>(R.id.up)
        val save = findViewById<ImageView>(R.id.save)
        val down = findViewById<ImageView>(R.id.down)

        up.setOnClickListener {
            if (layoutManager.findFirstVisibleItemPosition() != 0) {
                scrollToStart()
            } else {
                scrollToSaveLastPosition()
            }
        }

        save.setOnClickListener {
            savePosition()
        }

        down.setOnClickListener {
            if (layoutManager.findLastVisibleItemPosition() != adapter.itemCount - 1) {
                scrollToEnd()
            } else {
                scrollToSaveStartPosition()
            }
        }
    }
}