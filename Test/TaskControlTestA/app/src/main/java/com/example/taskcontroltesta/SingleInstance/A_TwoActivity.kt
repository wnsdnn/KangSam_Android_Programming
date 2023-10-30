package com.example.taskcontroltesta.SingleInstance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAtwo4Binding
import java.lang.Exception

class A_TwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtwo4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atwo4)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_atwo4)

        binding.BoneBtn.setOnClickListener {
            try {
                val intent = Intent("ACTION_SINGLEINSTANCE_BONE")
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "TaskControlTestB 앱을 먼저 설치해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}