package com.example.viewpager2.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2.Fragments.OneFragment
import com.example.viewpager2.Fragments.ThreeFragment
import com.example.viewpager2.Fragments.TwoFragment

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