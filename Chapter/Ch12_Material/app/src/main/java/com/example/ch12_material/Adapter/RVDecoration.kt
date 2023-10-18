package com.example.ch12_material.Adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

class RVDecoration(val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1

        if (index % 3 == 0) {
            outRect.set(10, 10, 10, 60)
        } else {
            outRect.set(10, 10, 10, 10)
        }

        view.setBackgroundColor(Color.parseColor("#28a0ff"))
        ViewCompat.setElevation(view, 20.0f)

    }

}