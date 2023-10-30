package com.example.taskcontroltestb.SingleInstance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltestb.R
import com.example.taskcontroltestb.databinding.ActivityBone2Binding

class B_OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBone2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bone2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bone2)

        binding.BtwoBtn.setOnClickListener {
            val intent = Intent(this, B_TwoActivity::class.java)
            startActivity(intent)
        }
    }
}