package com.example.broadcastreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
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

        val chargingStatusBtn = binding.chargingStatusBtn
        val batteryTxt = binding.batteryTxt


        // 배터리 상태 체크
//        val receiver = object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent?) {
//                when (intent?.action) {
//                    Intent.ACTION_BATTERY_OKAY -> Toast.makeText(context, "배터리 정상", Toast.LENGTH_SHORT).show()
//                    Intent.ACTION_BATTERY_LOW -> Toast.makeText(context, "배터리 낮음", Toast.LENGTH_SHORT).show()
//                    Intent.ACTION_BATTERY_CHANGED -> Toast.makeText(context, "충전 상태", Toast.LENGTH_SHORT).show()
//                    Intent.ACTION_POWER_CONNECTED-> Toast.makeText(context, "전원 공급 시작", Toast.LENGTH_SHORT).show()
//                    Intent.ACTION_POWER_DISCONNECTED -> Toast.makeText(context, "전원 공급 해제", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//
//        val filter = IntentFilter(Intent.ACTION_BATTERY_OKAY).apply {
//            addAction(Intent.ACTION_BATTERY_LOW)
//            addAction(Intent.ACTION_BATTERY_CHANGED)
//            addAction(Intent.ACTION_POWER_CONNECTED)
//            addAction(Intent.ACTION_POWER_DISCONNECTED)
//        }
//
//        registerReceiver(receiver, filter)



        // 충전상태 버튼 눌렀을때
        chargingStatusBtn.setOnClickListener {
            // ACTION_BATTERY_CHANGED => 전원이 공급되고 있는 상태
            val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            val batteryStatus = registerReceiver(null, intentFilter)

            val status = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
                // 전원이 공급되고 있다면
                val chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
                when(chargePlug) {
                    // BatteryManager.BATTERY_PLUGGED_USB => 저속 충전 상태
                    // BatteryManager.BATTERY_PLUGGED_AC => 고속 충전 상태
                    BatteryManager.BATTERY_PLUGGED_USB -> Toast.makeText(this, "USB 상태", Toast.LENGTH_SHORT).show()
                    BatteryManager.BATTERY_PLUGGED_AC -> Toast.makeText(this, "AC 상태", Toast.LENGTH_SHORT).show()
                }
            } else {
                // 전원이 공급되고 있지 않다면
                Toast.makeText(this, "전원 해제", Toast.LENGTH_SHORT).show()
            }
        }




        // 배터리 잔량이 바뀌면 자동으로 화면에 업데이트 쳐주기
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                // 배터리 상태 변경 액션을 확인
                if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
                    // 배터리 상태 및 잔량 정보 가져오기
                    val level = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    val scale = intent!!.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                    val batteryPct = (level.toFloat() / scale.toFloat()) * 100
                    batteryTxt.text = "남은 배터리 잔량: $batteryPct%"
                }
            }
        }

        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(receiver, filter)
    }
}