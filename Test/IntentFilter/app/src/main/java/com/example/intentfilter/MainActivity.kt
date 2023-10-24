package com.example.intentfilter

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.intentfilter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btn.setOnClickListener {
//            val intent = Intent()
//            intent.action = "ACTION_EDIT"
//            intent.data = Uri.parse("http://www.google.com")

            // 이런식으로도 가능
            val intent = Intent("ACTION_EDIT", Uri.parse("http://www.google.com"))

            startActivity(intent)
        }


        binding.btn2.setOnClickListener {
            val intent = Intent("ACTION_EDIT")
            intent.type = "image/*"
            startActivity(intent)
        }


    }
}