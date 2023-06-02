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

        // service
        startService(Intent(this, MyService::class.java))

        binding.startButton.setOnClickListener { onClickStart() }
        binding.stopButton.setOnClickListener { onClickStop() }
    }

    private fun onClickStart() {
        // view
        binding.startButton.isEnabled = false
        binding.stopButton.isEnabled = true

        Log.d(TAG, "MainActivity - onClickStart() called")
        val intent = Intent("PLAY_TO_SERVICE")
        intent.putExtra("mode", "start")
        sendBroadcast(intent)
    }

    private fun onClickStop() {
        // view
        binding.startButton.isEnabled = true
        binding.stopButton.isEnabled = false

        val intent = Intent("PLAY_TO_SERVICE")
        intent.putExtra("mode", "stop")
        sendBroadcast(intent)
        // service
        startService(Intent(this, MyService::class.java))
    }

    override fun onDestroy() {
        // destroy service
        stopService(Intent(this, MyService::class.java))
        super.onDestroy()
    }
}