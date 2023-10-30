package com.example.taskcontroltesta.SingleTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAtwo3Binding

class A_TwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtwo3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atwo3)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_atwo3)

        binding.BoneBtn.setOnClickListener {

        }
    }
}