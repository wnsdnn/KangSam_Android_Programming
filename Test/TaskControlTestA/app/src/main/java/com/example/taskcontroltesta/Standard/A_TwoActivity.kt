package com.example.taskcontroltesta.Standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAtwoBinding

class A_TwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atwo)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_atwo)

        binding.AtwoBtn.setOnClickListener {
            val intent = Intent(this, A_TwoActivity::class.java)
            startActivity(intent)
        }
    }
}