package com.example.startactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.startactivityforresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.detailBtn.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            // 결과를 돌려받을수 있도록 startActivity() 함수 대신 startActivityForResult() 함수 사용
            startActivityForResult(intent, 10)
        }
    }


    // 다시 화면으로 돌아왔을때
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // requestCode가 같고 resultCode가 RESULT_OK일때 실행
        if(requestCode == 10 && resultCode == RESULT_OK) {
            // detail페이지에서 넣어준 데이터 가져오기
            val result = data?.getStringExtra("resultData")

            // 토스트 메시지로 가져온 데이터 값 출력
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }

    }
}