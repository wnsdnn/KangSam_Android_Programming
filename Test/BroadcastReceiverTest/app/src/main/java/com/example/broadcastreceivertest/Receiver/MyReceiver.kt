package com.example.broadcastreceivertest.Receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
//        Toast.makeText(context, "부팅 완료", Toast.LENGTH_SHORT).show()
    }
}