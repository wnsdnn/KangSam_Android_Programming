package com.example.materiallib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.materiallib.Adapter.RVAdapter
import com.example.materiallib.Decoration.RVDecoration
import com.example.materiallib.databinding.ActivityCollapsingToolbarBinding

class CollapsingToolbarActivity : AppCompatActivity() {

    lateinit var binding: ActivityCollapsingToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_collapsing_toolbar)


        val items = mutableListOf<String>()
        for (i in 1..15) {
            items.add("item $i")
        }


        val rv = binding.rv
        val adapter = RVAdapter(items)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration(RVDecoration(this))

    }
}