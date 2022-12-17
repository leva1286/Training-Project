package com.gordietsdev.trainingproject

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val date = mutableListOf<String>()

        for (i in 0..99) {
            date.add(i,"${i + 1}")
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        //  создаем адаптер
        val adapter = Adapter(date)
        //Включаем StableIds
        adapter.setHasStableIds(true)

        // присваиваем одаптер нашему recyclerView
        recyclerView.adapter = adapter
        // присваемаем ItemDecoration нашему recyclerView
        recyclerView.addItemDecoration(ItemOffsetsDecoration(this))

        //Загружаем анимацию, созданную в XML формате
        val anim = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation)
        //Передаем ее в recyclerView
        recyclerView.layoutAnimation = anim
        //Запускаем анимацию на выполнение
        recyclerView.scheduleLayoutAnimation()

        // присваем itemAnimator recyclerView
        recyclerView.itemAnimator = MyItemAnimator(this)

        val btn1 = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)

        btn1.setOnClickListener {
            //Изменился текст
            adapter.date[0] = "7043"
            //Оповещаем RecyclerView об изменениях, используя payload
            adapter.notifyItemChanged(0, "text")

            adapter.date.add("lol")
            adapter.notifyItemInserted(adapter.date.size - 1)
        }

        btn2.setOnClickListener {
            adapter.date.removeLast()
            adapter.notifyItemRemoved(adapter.date.size)
        }
    }
}