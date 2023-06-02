package com.example.apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apipractice.databinding.ActivityMainBinding
import com.example.apipractice.retrofit.RetrofitManager
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val retrofitManager = RetrofitManager.instance

    private var year: Int? = null
    private var month: Int? = null
    private var day: Int? = null

    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ev_text = binding.evDay
        val tv_text = binding.tvDay
        val today = today() - 1
        Log.d(TAG, "$today - onCreate() called")
        retrofitManager.getBoxOffice(today.toString())
        tv_text.text = today.toString()

        binding.searchBtn.setOnClickListener {
            var day_text = ev_text.text.toString()

//            RetrofitManager.getBoxOffice(day_text, binding)
            retrofitManager.getBoxOffice(day_text)

            tv_text.text = day_text
            ev_text.setText("")
        }
    }/*

    private fun go(today: Int) {
        val retrofitClient = RetrofitClient.getClient()
        retrofitClient.getBoxOffice(API.KEY, today.toString()).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val result = response.body()
                // json.결과.영화리스트
                val movieList = result?.boxOfficeResult?.dailyBoxOfficeList
                Log.d("retrofit", "성공")
                bindMovies(movieList!!)
            }
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("retrofit", t.message ?: "에러")
            }
        })
    }*/



    // 오늘 날짜 구하기
    private fun today() : Int {
        val today: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        year = today.slice(0..3)?.toInt()
        month = today.slice(4..5)?.toInt()
        day = today.slice(6..7)?.toInt()
        Log.d(TAG, "today() - $today")
        return today.toInt()
    }
}