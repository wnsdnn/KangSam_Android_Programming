package com.example.intentfilter

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.intentfilter.databinding.ActivityMainBinding
import java.lang.Exception
import java.nio.channels.InterruptedByTimeoutException

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


        binding.btn3.setOnClickListener {
            val intent = Intent("ACTION_WNDSNN")

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "액티비티가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btn4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37,7749, 127.4194"))
            startActivity(intent)
        }


        binding.btn5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749, 127.4194"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }


    }
}