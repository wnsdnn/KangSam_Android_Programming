package com.example.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.broadcastreceivertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (intent?.action) {
                    Intent.ACTION_SCREEN_ON -> Toast.makeText(context, "화면 ON", Toast.LENGTH_SHORT).show()
                    Intent.ACTION_SCREEN_OFF -> Toast.makeText(context, "화면 OFF", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val filter = IntentFilter(Intent.ACTION_SCREEN_ON).apply {
            addAction(Intent.ACTION_SCREEN_OFF)
        }

//        registerReceiver(receiver, filter)


        binding.removeBtn.setOnClickListener {
            // 리시버 등록 해제
            unregisterReceiver(receiver)
            Toast.makeText(this, "리시버 삭제", Toast.LENGTH_SHORT).show()
        }

    }
}