package com.ivand.game.utilies

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class SpacesItemDecoration(private val mSpace: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        mSpace.let {
            outRect.apply {
                left = it
                right = it
                bottom = it
            }
        }

        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = mSpace
    }
}