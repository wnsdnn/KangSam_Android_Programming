package com.example.testandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent

class TouchEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_event)

    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("fdsa: ", "Touch down event x: ${event?.x} , rawX: ${event?.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("fdsa: ", "Touch up event")
            }
        }


        return super.onTouchEvent(event)
    }
}