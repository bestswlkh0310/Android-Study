package com.example.apipractice.retrofit

import android.util.Log
import com.example.apipractice.databinding.ActivityMainBinding
import com.example.apipractice.moveRv.MovieManager
import com.example.apipractice.utils.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.apipractice.movieApi.Result

class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
//        private val movieManager = MovieManager
    }
    val TAG: String = "로그"
    private val retrofitClient : RetrofitInterface = RetrofitClient().getClient(API.URL).create(RetrofitInterface::class.java)

    fun getBoxOffice(targetDt: String) {
        Log.d(TAG, "Day - $targetDt - getBoxOffice")

        retrofitClient?.getBoxOffice(API.KEY, targetDt)?.enqueue(object: Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val result = response.body()
                // json.결과.영화리스트
                val movieList = result?.boxOfficeResult?.dailyBoxOfficeList
                Log.d(TAG, "${result?.boxOfficeResult?.dailyBoxOfficeList}")
                Log.d(TAG, "성공")
//                movieManager.bindMovies(movieList!!, binding)
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("retrofit", t.message ?: "에러")
            }
        })
    }

}