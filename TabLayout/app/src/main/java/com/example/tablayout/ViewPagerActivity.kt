package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tablayout.Adapter.ViewPagerAdapter
import com.example.tablayout.databinding.ActivityViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager)

        val tabLayout = binding.tabs
        val viewPager = binding.viewpager

//        val tab1 = tabLayout.newTab()
//        tab1.text = "tab1"
//        tabLayout.addTab(tab1)
//
//        val tab2 = tabLayout.newTab()
//        tab2.text = "tab2"
//        tabLayout.addTab(tab2)
//
//        val tab3 = tabLayout.newTab()
//        tab3.text = "tab3"
//        tabLayout.addTab(tab3)



        val tabNameArr = mutableListOf<String>("tab1", "tab2", "tab3")
        viewPager.adapter = ViewPagerAdapter(this)


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNameArr[position]
        }.attach()


    }
}