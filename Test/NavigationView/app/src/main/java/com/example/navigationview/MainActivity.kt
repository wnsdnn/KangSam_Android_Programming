package com.example.navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.navigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.drawerView.setNavigationItemSelectedListener { it ->
            Toast.makeText(this, "${it.title}", Toast.LENGTH_SHORT).show()

            true
        }


        binding.extendedFab.setOnClickListener {
            when (binding.extendedFab.isExtended) {
                true -> binding.extendedFab.shrink()
                false -> binding.extendedFab.extend()
            }
        }

    }
}