package com.example.menu_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val menuItem1: MenuItem? = menu?.add(0, 0, 0, "menu1")
//        val menuItem2: MenuItem? = menu?.add(0, 1, 0, "menu2")

        // 일반 메뉴
//        menuInflater.inflate(R.menu.menu_main, menu)

        // 검색 메뉴
        menuInflater.inflate(R.menu.search_menu, menu)

        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 키보드의 검색 버튼을 클릭한 순간의 이벤트
                Toast.makeText(this@MainActivity, "$query", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // 검색어 변경 이벤트
                Log.d("kkang", "$newText")
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        0 -> {
            Log.d("kkang", "menu1 click")
            true
        }
        1 -> {
            Log.d("kkang", "menu2 click")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}