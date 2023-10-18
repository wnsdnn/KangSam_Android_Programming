package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2.Adapter.FragmentAdapter
import com.example.viewpager2.Adapter.RVAdapter
import com.example.viewpager2.Fragments.OneFragment
import com.example.viewpager2.Fragments.ThreeFragment
import com.example.viewpager2.Fragments.TwoFragment
import com.example.viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // RecyclerView.Adapter로 뷰페이저 구현
//        val items = mutableListOf<String>()
//        items.add("item1")
//        items.add("item2")
//        items.add("item3")
//
//        val viewpager = binding.viewpager
//        viewpager.adapter = RVAdapter(items)


        // FragmentStateAdapter로 뷰페이저 구현
        val viewpager = binding.viewpager
        viewpager.adapter = FragmentAdapter(this@MainActivity)

        viewpager.orientation = ViewPager2.ORIENTATION_VERTICAL
        Toast.makeText(this@MainActivity, "세로 스와이프!", Toast.LENGTH_SHORT).show()

    }
}