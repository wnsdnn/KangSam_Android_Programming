package com.example.taskcontroltesta.SingleTop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAone2Binding

class A_OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAone2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aone2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aone2)

        binding.AtowBtn.setOnClickListener {
            val intent = Intent(this, A_TwoActivity::class.java)
            startActivity(intent)
        }
    }
}