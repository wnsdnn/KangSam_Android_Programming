package com.example.materiallib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.materiallib.databinding.ActivityToolBarBinding

class ToolBarActivity : AppCompatActivity() {

    lateinit var binding: ActivityToolBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tool_bar)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

    }
}