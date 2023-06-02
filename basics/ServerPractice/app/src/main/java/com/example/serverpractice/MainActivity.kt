package com.example.serverpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.serverpractice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            RetrofitClient.api.getUser().enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d(TAG, "성공")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d(TAG, "실패")
                    Log.d(TAG, "${call} ${t.message}")
                }
            })
        }
    }
}