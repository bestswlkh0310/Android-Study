package com.example.apipractice.retrofit

import com.example.apipractice.API
import com.example.apipractice.movieApi.Result
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// using : getBoxOffice(key, day) => Result 반환
interface RetrofitInterface {
    @GET(API.URL) // 키, 날짜 => 결과
    fun getBoxOffice(@Query("key") key: String, @Query("targetDt") targetDt: String): Call<Result>
}