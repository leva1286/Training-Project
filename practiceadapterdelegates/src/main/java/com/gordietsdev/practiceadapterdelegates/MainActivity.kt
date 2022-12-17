package com.gordietsdev.practiceadapterdelegates

import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gordietsdev.practiceadapterdelegates.adapter.ProductAdapter
import com.gordietsdev.practiceadapterdelegates.diff.MyDiff
import com.gordietsdev.practiceadapterdelegates.model.Countable
import com.skill_factory.unit5.model.Ad
import com.skill_factory.unit5.model.Item
import com.skill_factory.unit5.model.Product
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private val KEY_MANAGER_STATE: String = "KeyForLayoutManagerState"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ProductAdapter()

        adapter.items = arrayListOf(
            Product(
                0,
                R.drawable.ic_apple,
                "Apple",
                "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
            ),
            Ad("Акция", "Скидка на бананы 15%", 7),
            Countable(R.drawable.ic_banana, 32, "Banana", "Бананы вкусные и крутые", 6),
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
            )
        )
        recyclerView.adapter = adapter

        fun updateData(newList: ArrayList<Item>) {
            val diff = MyDiff(adapter.items as ArrayList<Item>, newList)
            val diffResult = DiffUtil.calculateDiff(diff)
            adapter.items = newList
            diffResult.dispatchUpdatesTo(adapter)
        }

        val btnRefresh = findViewById<Button>(R.id.btn_sh)

        btnRefresh.setOnClickListener {
            val newList = arrayListOf<Item>()
            newList.addAll(adapter.items)
            newList.shuffle(Random())
            updateData(newList)
        }
    }
}