package com.gordietsdev.practicediffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val list = arrayListOf<Num>()

        for (i in 0 until 30) {
            list.add(Num(i, i + 1))
        }

        val adapter = MyAdapter(list)

        recyclerView.adapter = adapter

        val btnRefresh = findViewById<Button>(R.id.refresh)

        fun updateData(newList: ArrayList<Num>) {
            val diff = MyDiff(adapter.data, newList)
            val diffResult = DiffUtil.calculateDiff(diff)
            adapter.data = newList
            diffResult.dispatchUpdatesTo(adapter)
        }

        btnRefresh.setOnClickListener {
            val newList = arrayListOf<Num>()
            newList.addAll(list)
            newList.shuffle(Random())
            updateData(newList)
        }
    }
}