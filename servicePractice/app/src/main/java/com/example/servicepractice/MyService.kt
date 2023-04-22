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
    val TAG: String = "로그"

    var receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d(TAG, "MyService - onReceive() called")
            val mode = intent?.getStringExtra("mode")
            if(mode != null){
                if(mode == "start"){
                    try{
                        if(player.isPlaying){
                            Log.d(TAG, "MyService - onReceive() called")
                            player.stop()
                            player.release()
                        }
                        player = MediaPlayer.create(context, R.raw.music)
                        player.start()
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }else if(mode == "stop"){
                    if(player.isPlaying){
                        player.stop()
                    }
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
        registerReceiver(receiver, IntentFilter("PLAY_TO_SERVICE"))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}