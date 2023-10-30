package com.example.taskcontroltestb.SingleTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltestb.R
import com.example.taskcontroltestb.databinding.ActivityBoneBinding

class B_OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bone)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bone)

        binding.BtwoBtn.setOnClickListener {
            val intent = Intent(this, B_TwoActivity::class.java)
            startActivity(intent)
        }

    }
}