package com.example.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.broadcastreceivertest.databinding.ActivityBatteryTestBinding

class BatteryTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBatteryTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery_test)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_battery_test)


        // 배터리 상태 체크
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (intent?.action) {
                    Intent.ACTION_BATTERY_OKAY -> Toast.makeText(context, "배터리 정상", Toast.LENGTH_SHORT).show()
                    Intent.ACTION_BATTERY_LOW -> Toast.makeText(context, "배터리 낮음", Toast.LENGTH_SHORT).show()
                    Intent.ACTION_BATTERY_CHANGED -> Toast.makeText(context, "충전 상태", Toast.LENGTH_SHORT).show()
                    Intent.ACTION_POWER_CONNECTED-> Toast.makeText(context, "전원 공급 시작", Toast.LENGTH_SHORT).show()
                    Intent.ACTION_POWER_DISCONNECTED -> Toast.makeText(context, "전원 공급 해제", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val filter = IntentFilter(Intent.ACTION_BATTERY_OKAY).apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_BATTERY_CHANGED)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }

        registerReceiver(receiver, filter)



    }
}