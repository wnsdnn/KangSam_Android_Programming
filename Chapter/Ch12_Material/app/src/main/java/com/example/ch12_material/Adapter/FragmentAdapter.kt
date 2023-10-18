package com.example.ch12_material.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ch12_material.Fragments.OneFragment
import com.example.ch12_material.Fragments.ThreeFragment
import com.example.ch12_material.Fragments.TwoFragment

class FragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {

    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}