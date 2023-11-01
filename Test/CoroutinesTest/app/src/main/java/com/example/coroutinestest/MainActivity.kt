package com.example.coroutinestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinestest.databinding.ActivityMainBinding
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val startBtn = binding.startBtn
        val resultText = binding.resultText
        var sum = 0L

        startBtn.setOnClickListener {
            val time = measureTimeMillis {
                for (i in 1..2_000_000_000) {
                    sum += i
                }
            }

            Log.d("kkang", "time: $time")
            resultText.text = "sum: $sum"
        }

    }
}