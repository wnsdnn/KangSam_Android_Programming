package com.example.taskcontroltesta.SingleTop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taskcontroltesta.R
import com.example.taskcontroltesta.databinding.ActivityAthreeBinding
import com.example.taskcontroltesta.databinding.ActivityAtwo2Binding

class A_TwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtwo2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atwo2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_atwo2)

        binding.AtwoBtn.setOnClickListener {
            val intent = Intent(this, A_TwoActivity::class.java)
            startActivity(intent)
        }

        binding.AthreeBtn.setOnClickListener {
            val intent = Intent(this, A_ThreeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "자기 자신인 인텐츠 호출. 인텐츠 생성 X", Toast.LENGTH_SHORT).show()
    }
}