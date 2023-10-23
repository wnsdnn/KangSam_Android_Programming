package com.example.startactivityforresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.startactivityforresult.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.backBtn.setOnClickListener {
            // intent에 데이터 집어넣기
            intent.putExtra("resultData", "으헤헤 다시 돌아왔구나??")
            // resultCode값과 data값 세팅
            setResult(RESULT_OK, intent)

            // 뒤로가기
            finish()
        }

    }
}