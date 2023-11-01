package com.example.coroutinestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinestest.databinding.ActivityThreadBinding
import kotlinx.coroutines.handleCoroutineException
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class ThreadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_thread)


        val startBtn = binding.startBtn
        val resultText = binding.resultText

        val handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                resultText.text = "sum: ${msg.arg1}"
            }
        }

        startBtn.setOnClickListener {
            thread {
                var sum = 0L
                val time = measureTimeMillis {
                    for (i in 1..2_000_000_000) {
                        sum += i
                    }
                    val message = Message()
                    message.arg1 = sum.toInt()
                    handler.sendMessage(message)
                }
                Log.d("kkang", "time: $time")
            }
        }
    }
}