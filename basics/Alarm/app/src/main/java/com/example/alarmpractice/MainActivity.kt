package com.example.alarmpractice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.alarmpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 채널에 대한 각종 설정(불빛, 진동 등)
            val channelId = "channel"
            val channelName = "Name"
            val channelDescription = "채널 설명입니다"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            channel.description = channelDescription
            channel.enableLights(true)
            channel.lightColor = Color.RED // 색
            channel.setShowBadge(true) // 벳지
            channel.enableVibration(true) // 진동
            channel.vibrationPattern = longArrayOf(100L, 200L, 300L) // 진동 패턴

            // 시스템에 notificationChannel 등록
            manager.createNotificationChannel(channel)
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        builder.run {
            setSmallIcon(R.drawable.ic_launcher_background) // 아이콘 설정
            setContentTitle("Content Title") // 알림 메세지 설정
            setContentText("dkoashduahofidhsa") // 알림 내용 설정
            setWhen(System.currentTimeMillis()) // 시간 설정
            setDefaults(Notification.DEFAULT_VIBRATE) // 알림과 동시에 진동 설정(권한 필요)
            setAutoCancel(true) // 클릭 시 알림이 삭제되도록 설정
        }

        binding.btn.setOnClickListener {
            Log.d("asd", "MainActivity - onCreate() called")
            manager.notify(0, builder.build())
        }
    }
}