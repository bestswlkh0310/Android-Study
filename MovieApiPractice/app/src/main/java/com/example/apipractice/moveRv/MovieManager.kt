package com.example.apipractice.moveRv

import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipractice.MainActivity
import com.example.apipractice.databinding.ActivityMainBinding
import com.example.apipractice.movieApi.DailyBoxOfficeList

object MovieManager {
    fun bindMovies(movieList : List<DailyBoxOfficeList>, binding: ActivityMainBinding) {
        var movieDataList: Array<Movies?> = arrayOfNulls(10)
        val rv_movie_rank = binding.rvMovieRank
        // 영화리스트의 0~9 인덱스 출력 : 영화 이름 출력
        for (i in 0 until 10) {
            Log.d(TAG, "result - ${movieList?.get(i)?.movieNm}, ${movieList?.get(i)?.rank?.toInt()}, ${movieList?.get(i)?.openDt}")
            movieDataList[i] = Movies(movieList?.get(i)?.movieNm, movieList?.get(i)?.rank?.toInt(), movieList?.get(i)?.openDt)
        }
        rv_movie_rank.layoutManager = LinearLayoutManager(MainActivity(), LinearLayoutManager.VERTICAL, false)
        rv_movie_rank.setHasFixedSize(true)
        rv_movie_rank.adapter = MovieAdapter(movieDataList)
    }
}