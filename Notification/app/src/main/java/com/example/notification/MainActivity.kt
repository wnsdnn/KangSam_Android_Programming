package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.data.UrspRule
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var builder: NotificationCompat.Builder
    private lateinit var manager: NotificationManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        initBuilder()

        binding.notificationBtn.setOnClickListener {
            sendNotification()
        }

        binding.cancelBtn.setOnClickListener {
            notificationCencel()
        }
    }

    fun notificationCencel() {
        // 알림 삭제
        manager.cancel(11)
    }

    fun sendNotification() {
        builder.setSmallIcon(R.drawable.baseline_notifications_24)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("타이틀 입니다.")
        builder.setContentText("알림의 내용입니다.")
        
        // 사용자가 알람을 지울수 없게 만들어주는 코드
//        builder.setAutoCancel(false)
//        builder.setOngoing(true)

        // 터치했을때 이동시킬 Intent
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this@MainActivity,
            10,
            intent,
            PendingIntent.FLAG_IMMUTABLE)

        builder.setContentIntent(pendingIntent)


        // 알람에 Action 추가
        builder.addAction(
            NotificationCompat.Action.Builder(
                R.drawable.baseline_notifications_paused_24,
                "액션1",
                pendingIntent
            ).build()
        )
        builder.addAction(
            NotificationCompat.Action.Builder(
                R.drawable.baseline_notifications_paused_24,
                "액션2",
                pendingIntent
            ).build()
        )
        builder.addAction(
            NotificationCompat.Action.Builder(
                R.drawable.baseline_notifications_paused_24,
                "액션3",
                pendingIntent
            ).build()
        )


        manager.notify(11, builder.build())
    }


    fun initBuilder() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )

            channel.description = "My Channel One Description"
            channel.setShowBadge(true)
            val uri : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()

            channel.setSound(uri, audioAttributes)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100, 200, 100, 200)

            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this@MainActivity, channelId)

        } else {
            builder = NotificationCompat.Builder(this@MainActivity)
        }
    }
}