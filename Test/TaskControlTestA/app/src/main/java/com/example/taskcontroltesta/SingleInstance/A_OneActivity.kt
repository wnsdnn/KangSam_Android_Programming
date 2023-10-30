package com.example.taskcontroltesta.SingleInstance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAone4Binding
import java.lang.Exception

class A_OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAone4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aone4)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aone4)

        binding.AtwoBtn.setOnClickListener {
            val intent = Intent(this, A_TwoActivity::class.java)
            startActivity(intent)
        }
    }
}