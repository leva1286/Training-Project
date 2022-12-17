package com.gordietsdev.trainingproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetsDecoration(private val context: Context) : RecyclerView.ItemDecoration() {

    // задаем свои отсупы для элементов recyclerview
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val hSide = context.resources.getDimension(R.dimen.h_side).toInt()
        val vSide = context.resources.getDimension(R.dimen.v_side).toInt()
        outRect.set(hSide, vSide, hSide, vSide)
    }

    // метод отрисовки view для recyclerview
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        parent.children.forEachIndexed { index, view ->
            if (index % 2 == 0) {
                view.setBackgroundResource(R.color.purple_700)
            } else {
                view.setBackgroundResource(R.color.black)
            }
        }
    }
}