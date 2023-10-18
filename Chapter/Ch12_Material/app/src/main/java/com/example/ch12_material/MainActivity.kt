package com.example.ch12_material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import com.example.ch12_material.Adapter.FragmentAdapter
import com.example.ch12_material.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        setSupportActionBar(binding.toolbar)

        var toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()


        val viewpager = binding.viewpager
        viewpager.adapter = FragmentAdapter(this)

        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = "Tabs ${(position + 1)}"
        }.attach()



        val fab = binding.fab

        fab.setOnClickListener {
            when (fab.isExtended) {
                true -> fab.shrink()
                false -> fab.extend()
            }
        }

    }
}