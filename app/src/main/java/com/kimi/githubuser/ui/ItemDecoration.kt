package com.kimi.githubuser.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Kimi.Peng on 2020/5/23.
 */
class ItemDecoration(private val dimenPixel: Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val doubleDimenPixel = dimenPixel * 2
        outRect.set(doubleDimenPixel, dimenPixel, doubleDimenPixel, dimenPixel)
    }
}