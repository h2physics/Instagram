package com.h2physics.instagram.ui.main

import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.util.Log

import com.h2physics.instagram.R
import com.h2physics.instagram.ui.adapter.PagerAdapter
import com.h2physics.instagram.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val LOG_TAG : String? = "MainActivity"

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val fragmentManager : FragmentManager? = supportFragmentManager;
        val adapter : PagerAdapter? = PagerAdapter(MainActivity@this, fragmentManager);
        pager.adapter = adapter
        tab.setupWithViewPager(pager)
        Log.e(LOG_TAG, tab.getTabAt(0).toString())
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.setTabsFromPagerAdapter(adapter)

    }

    override fun initData() {

    }



}
