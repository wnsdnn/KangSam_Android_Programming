package com.example.vibrator_test

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.databinding.DataBindingUtil
import com.example.vibrator_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.notificationBtn.setOnClickListener {
            StartNotification()
        }

        binding.vibratorBtn1.setOnClickListener {
            StartVibrator1()
        }

        binding.vibratorBtn2.setOnClickListener {
            StartVibrator2()
        }
    }

    fun StartVibrator2() {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibrationManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibrationManager.defaultVibrator
        } else {
            getSystemService(VIBRATOR_SERVICE) as Vibrator
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 0.5 딜레이 -> 1초 50의 세기로 진동 -> 0.5 딜레이 -> 2초 200의 세기로 진동 (-1: 1번 반복)
            // (진동시간 패턴 array, 진동세기 패턴 array, 반복횟수)
            vibrator.vibrate(VibrationEffect.createWaveform(longArrayOf(500, 1000, 500, 2000), intArrayOf(0, 50, 0, 200), -1))
        } else {
            vibrator.vibrate(longArrayOf(500, 1000, 50, 2000), -1)
        }
    }

    fun StartVibrator1() {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibrationManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibrationManager.defaultVibrator
        } else {
            getSystemService(VIBRATOR_SERVICE) as Vibrator
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // (초, 진동세기)
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))

            // 젤 약하게
//            vibrator.vibrate(VibrationEffect.createOneShot(500, 255))
            // 젤 세게
//            vibrator.vibrate(VibrationEffect.createOneShot(500, 255))
        } else {
            vibrator.vibrate(500)
        }
    }


    // 알림 소리 내는 함수
    fun StartNotification() {
       val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
       val ringtone = RingtoneManager.getRingtone(this@MainActivity, notification)
       ringtone.play()
    }

}