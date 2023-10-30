package com.example.taskcontroltesta.Standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAoneBinding

class A_OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aone)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aone)

        binding.AtwoBtn.setOnClickListener {
            val intent = Intent(this, A_TwoActivity::class.java)
            startActivity(intent)
        }
    }
}