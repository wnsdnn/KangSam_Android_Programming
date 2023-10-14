package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tablayout.Fragments.OneFragment
import com.example.tablayout.Fragments.ThreeFragment
import com.example.tablayout.Fragments.TwoFragment
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val tabLayout = binding.tabs

        val tab1: TabLayout.Tab = tabLayout.newTab()
        tab1.text = "Tab1"
        tabLayout.addTab(tab1)

        val tab2: TabLayout.Tab = tabLayout.newTab()
        tab2.text = "Tab2"
        tabLayout.addTab(tab2)

        val tab3: TabLayout.Tab = tabLayout.newTab()
        tab3.text = "Tab3"
        tabLayout.addTab(tab3)

//        val tab4: TabLayout.Tab = tabLayout.newTab()
//        tab4.text = "Tab4"
//        tabLayout.addTab(tab4)
//
//        val tab5: TabLayout.Tab = tabLayout.newTab()
//        tab5.text = "Tab5"
//        tabLayout.addTab(tab5)
//
//        val tab6: TabLayout.Tab = tabLayout.newTab()
//        tab6.text = "Tab6"
//        tabLayout.addTab(tab6)
//
//        val tab7: TabLayout.Tab = tabLayout.newTab()
//        tab7.text = "Tab7"
//        tabLayout.addTab(tab7)
//
//        val tab8: TabLayout.Tab = tabLayout.newTab()
//        tab8.text = "Tab8"
//        tabLayout.addTab(tab8)


        // 기본값 처리
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.tabContent, OneFragment())
        transaction.commit()

        // 탭 버튼 이벤트 처리
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭 버튼을 선택할 때 이벤트
                val transaction = supportFragmentManager.beginTransaction()

                when(tab?.text) {
                    "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
                    "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
                    "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 다른 탭 버튼을 눌러 선택된 탭 버튼이 해제될 때 이벤트
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 선택된 탭 버튼을 다시 선택할 때 이벤트
            }

        })

    }
}