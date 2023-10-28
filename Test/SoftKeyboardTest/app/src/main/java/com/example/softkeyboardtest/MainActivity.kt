package com.example.softkeyboardtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.softkeyboardtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        binding.showInputButton.setOnClickListener {
            binding.editView.requestFocus()
            manager.showSoftInput(binding.editView, InputMethodManager.SHOW_IMPLICIT)
            Toast.makeText(this, "키보드가 활성화되었습니다.", Toast.LENGTH_SHORT).show()
        }

        binding.hideInputButton.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            Toast.makeText(this, "키보드가 비활성화되었습니다.", Toast.LENGTH_SHORT).show()
        }

    }
}