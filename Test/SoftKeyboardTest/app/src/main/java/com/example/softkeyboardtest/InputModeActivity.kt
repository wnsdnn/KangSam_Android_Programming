package com.example.softkeyboardtest

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.softkeyboardtest.databinding.ActivityInputModeBinding

class InputModeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_mode)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_mode)

        // 에디트 텍스트 포커싱
        binding.editText.requestFocus()


        // 액티비티 전체화면으로 만드는 코드
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // API 레벨 30이상
            window.setDecorFitsSystemWindows(false)
            val controller = window.insetsController
            if (controller != null) {
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            // API 레벨 29이하
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }


    }
}