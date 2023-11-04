package com.example.ch13_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch13_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var datas: MutableList<String>
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        
        // 화면 새로 그릴때 이전 데이터가 남아있다면 불러오기
        val instanceDatas = savedInstanceState?.getStringArrayList("datas")
        datas = if(instanceDatas != null) {
            instanceDatas.toMutableList()
        } else {
            // 아님 빈값
            mutableListOf<String>()
        }
        adapter = MyAdapter(datas)


        // 팝업 등록화면에서 메인으로 돌아올때 실행
        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            it.data!!.getStringExtra("result")?.let {
                datas.add(it)
                Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            }
        }

        // Add Todo 버튼 클릭시 실행
        val mainFab = binding.mainFab
        mainFab.setOnClickListener {
            val itnent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(itnent)
        }

        val rv = binding.mainRecyclerView
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }


    // 화면 다시 들어왔을때 화면 데이터 유지
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("datas", ArrayList(datas))
    }
    
}