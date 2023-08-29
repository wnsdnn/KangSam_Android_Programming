package com.example.ch8_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.ch8_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var initTime = 0
    var pauseTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val chronometer = binding.chronometer
        val startBtn = binding.startButton
        val stopBtn = binding.stopButton
        val resetBtn = binding.resetButton

        startBtn.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            chronometer.start()

            stopBtn.isEnabled = true
            resetBtn.isEnabled = true
            startBtn.isEnabled = false
        }


        stopBtn.setOnClickListener {
            pauseTime = (chronometer.base - SystemClock.elapsedRealtime()).toInt()

            chronometer.stop()
            stopBtn.isEnabled = false
            startBtn.isEnabled = true
            resetBtn.isEnabled = true
        }


        resetBtn.setOnClickListener {
            pauseTime = 0

            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.stop()
            stopBtn.isEnabled = false
            resetBtn.isEnabled = false
            startBtn.isEnabled = true
        }

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if(keyCode === KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this, "종료하려면 한 번 더 누르세요 !!", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis().toInt()
                return false
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}