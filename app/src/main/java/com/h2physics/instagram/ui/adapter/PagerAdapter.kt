package com.h2physics.instagram.ui.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.DynamicDrawableSpan
import android.text.style.ImageSpan
import com.h2physics.instagram.R

import com.h2physics.instagram.ui.collection.CollectionFragment
import com.h2physics.instagram.ui.main.MainFragment
import com.h2physics.instagram.ui.search.SearchFragment
import com.h2physics.instagram.ui.user.UserFragment

/**
 * Created by YukiNoHara on 10/8/2017.
 */

class PagerAdapter(val context : Context?,
                    fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    var drawable : Drawable? = null

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = MainFragment()
            }
            1 -> {
                fragment = SearchFragment()
            }
            2 -> {
                fragment = CollectionFragment()
            }
            3 -> {
                fragment = UserFragment()
            }
        }
        return fragment
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title : String = "";
        when(position){
            0 -> {
                title = "Home"
                drawable = context?.resources?.getDrawable(R.drawable.ic_home)
            }
            1 -> {
                title = "Search"
                drawable = context?.resources?.getDrawable(R.drawable.ic_search)
            }
            2 -> {
                title = "Collection"
                drawable = context?.resources?.getDrawable(R.drawable.ic_collections)
            }
            3 -> {
                title = "User"
                drawable = context?.resources?.getDrawable(R.drawable.ic_user)
            }
        }
//        var spanStringBuilder : SpannableStringBuilder? = SpannableStringBuilder("  " + title)
//        drawable?.setBounds(5, 5, drawable!!.intrinsicWidth, drawable!!.intrinsicHeight)
//        val span : ImageSpan? = ImageSpan(drawable, DynamicDrawableSpan.ALIGN_BASELINE)
//        spanStringBuilder?.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        return title
    }


}
