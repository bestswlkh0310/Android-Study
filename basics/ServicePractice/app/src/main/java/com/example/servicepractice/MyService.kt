package com.example.servicepractice

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    lateinit var player: MediaPlayer
    companion object {
        const val TAG: String = "로그"
    }

    private lateinit var receiver: BroadcastReceiver

    override fun onCreate() {
        super.onCreate()

        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d(TAG, "MyService - onReceive() called")
                val mode =  intent?.extras?.getString("mode")
                if (mode == "start") {
                    if (player.isPlaying) {
                        Log.d(TAG, "MyService - onReceive() called")
                        player.stop()
                        player.release()
                    }
                    player = MediaPlayer.create(context, R.raw.music)
                    player.start()
                } else if(mode == "stop") {
                    if (player.isPlaying) {
                        player.stop()
                    }
                }
            }
        }

        player = MediaPlayer()
        registerReceiver(receiver, IntentFilter("PLAY_TO_SERVICE"))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}