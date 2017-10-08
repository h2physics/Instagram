package com.h2physics.instagram.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.h2physics.instagram.ui.collection.CollectionFragment
import com.h2physics.instagram.ui.main.MainFragment
import com.h2physics.instagram.ui.search.SearchFragment
import com.h2physics.instagram.ui.user.UserFragment

/**
 * Created by YukiNoHara on 10/8/2017.
 */

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            1 -> {
                fragment = MainFragment()
            }
            2 -> {
                fragment = SearchFragment()
            }
            3 -> {
                fragment = CollectionFragment()
            }
            4 -> {
                fragment = UserFragment()
            }
        }
        return fragment
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        val title = ""

        return super.getPageTitle(position)
    }


}
