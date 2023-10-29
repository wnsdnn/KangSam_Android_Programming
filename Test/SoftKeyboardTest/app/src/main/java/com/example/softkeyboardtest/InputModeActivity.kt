package com.example.softkeyboardtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.softkeyboardtest.databinding.ActivityInputModeBinding

class InputModeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_mode)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_mode)


        binding.editText.requestFocus()


    }
}