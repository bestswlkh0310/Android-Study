package com.example.servicepractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.servicepractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG: String = "로그"
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")
            val intent = Intent("PLAY_TO_SERVICE")
            intent.putExtra("mode", "start")
            sendBroadcast(intent)

            binding.startButton.isEnabled = false
            binding.stopButton.isEnabled = true
        }

        binding.stopButton.setOnClickListener {
            val intent = Intent("PLAY_TO_SERVICE")
            intent.putExtra("mode", "stop")
            sendBroadcast(intent)

            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
        }

        startService(Intent(this, MyService::class.java))
    }

    override fun onDestroy() {
        stopService(Intent(this, MyService::class.java))
        super.onDestroy()
    }
}