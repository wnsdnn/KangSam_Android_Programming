package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.Adapter.RVAdapter
import com.example.recyclerview.Decoration.RVDecoration
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // 리사이클러뷰 적용
        val items = mutableListOf<String>()
        items.add("item1")
        items.add("item2")
        items.add("item3")
        items.add("item4")
        items.add("item5")
        items.add("item6")
        items.add("item7")
        items.add("item8")
        items.add("item9")

        val rv = binding.rv
        val adapter = RVAdapter(items)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this@MainActivity)


        // 데커레이션 적용
        rv.addItemDecoration(RVDecoration(this@MainActivity))
    }
}