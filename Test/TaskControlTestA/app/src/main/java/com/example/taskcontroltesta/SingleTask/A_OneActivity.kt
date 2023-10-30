package com.example.taskcontroltesta.SingleTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAone3Binding

class A_OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAone3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aone3)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aone3)

        binding.AtowBtn.setOnClickListener {
            val intent = Intent(this, A_TwoActivity::class.java)
            startActivity(intent)
        }
    }
}