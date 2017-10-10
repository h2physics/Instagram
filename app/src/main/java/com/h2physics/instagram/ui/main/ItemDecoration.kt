package com.h2physics.instagram.ui.main

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by YukiNoHara on 10/10/2017.
 */

class ItemDecoration constructor(val divider: Drawable?) : RecyclerView.ItemDecoration (){

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent?.getChildAdapterPosition(view) == 0){
            return
        }
        outRect?.top = divider?.intrinsicHeight
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        val dividerLeft : Int? = parent?.paddingLeft
        val dividerRight : Int? = parent?.width!! - parent.paddingRight

        val childCount : Int? = parent.childCount
        for (i in 0..(childCount!! - 1)){
            val child : View? = parent.getChildAt(i)
            val params : RecyclerView.LayoutParams = child?.layoutParams as RecyclerView.LayoutParams
            val dividerTop : Int? = child.bottom + params.bottomMargin
            val dividerBottom : Int? = dividerTop!! + divider?.intrinsicHeight!!

            divider.setBounds(dividerLeft!!, dividerTop, dividerRight!!, dividerBottom!!)
            divider.draw(c)
        }

    }

}


