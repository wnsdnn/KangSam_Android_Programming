package com.example.ch13_activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.ch13_activity.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_add)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 앱바에 옵션 선택했을때
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            // 저장버튼 클릭시
            R.id.menu_add_save -> {
                val intent = intent
                intent.putExtra("result", binding.addEditView.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
                true
            }
            else -> {
                true
            }
        }
    }
}