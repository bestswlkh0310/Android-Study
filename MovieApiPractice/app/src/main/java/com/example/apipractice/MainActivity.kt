package com.example.apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipractice.movieApi.DailyBoxOfficeList
import com.example.apipractice.databinding.ActivityMainBinding
import com.example.apipractice.movieApi.Result
import com.example.apipractice.moveRv.MovieAdapter
import com.example.apipractice.moveRv.Movies
import com.example.apipractice.retrofit.RetrofitClient
import retrofit2.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
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

        go(today)
        tv_text.text = today.toString()

        binding.searchBtn.setOnClickListener {
            var day_text = ev_text.text.toString()

            go(day_text.toInt())
            tv_text.text = day_text
            ev_text.setText("")
        }
    }

    private fun go(today: Int) {
        val retrofitInterface = RetrofitClient.getRetrofitInterface()
        retrofitInterface.getBoxOffice(API.KEY, today.toString()).enqueue(object : Callback<Result> {
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
    }

    private fun bindMovies(movieList : List<DailyBoxOfficeList>) {
        var movieDataList: Array<Movies?> = arrayOfNulls(10)
        val rv_movie_rank = binding.rvMovieRank
        // 영화리스트의 0~9 인덱스 출력 : 영화 이름 출력
        for (i in 0 until 10) {
            Log.d(TAG, "result - ${movieList?.get(i)?.movieNm}, ${movieList?.get(i)?.rank?.toInt()}, ${movieList?.get(i)?.openDt}")
            movieDataList[i] = Movies(movieList?.get(i)?.movieNm, movieList?.get(i)?.rank?.toInt(), movieList?.get(i)?.openDt)
        }
        rv_movie_rank.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_movie_rank.setHasFixedSize(true)
        rv_movie_rank.adapter = MovieAdapter(movieDataList)
    }

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