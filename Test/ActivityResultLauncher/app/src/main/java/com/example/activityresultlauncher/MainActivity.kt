package com.example.activityresultlauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.activityresultlauncher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // registerForActivityResult 객체 생성
        val requestLauncher: ActivityResultLauncher<Intent> =
            // intent를 발생시키는 StartActivityForResult 객체를 사용
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                // resultData 받아오기
                val resultData = it.data?.getStringExtra("resultData")
                Toast.makeText(this, resultData, Toast.LENGTH_SHORT).show()
            }


        binding.detailBtn.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            requestLauncher.launch(intent)
        }

    }
}