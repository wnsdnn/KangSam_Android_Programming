package com.example.coroutinestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinestest.databinding.ActivityCoroutineScopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class CoroutineScopeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutineScopeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_scope)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_scope)


        val startBtn = binding.startBtn
        val resultText = binding.resultText

        startBtn.setOnClickListener {
            val channel = Channel<Int>()
            val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
            backgroundScope.launch {
                var sum = 0L
                val time = measureTimeMillis {
                    for (i in 1..2_000_000_000) {
                        sum += i
                    }
                }
                Log.d("kkang", "time: $time")
                channel.send(sum.toInt())
            }

            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    resultText.text = "sum: $it"
                }
            }
        }


    }
}