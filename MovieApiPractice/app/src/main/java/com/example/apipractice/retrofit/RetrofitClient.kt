package com.example.apipractice.retrofit

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private var retrofitClient: Retrofit? = null
    val TAG: String = "로그"

    fun getClient(baseUrl: String): Retrofit {
        Log.d(TAG, "$baseUrl - getClient() called")
        // retrofitClient가 없으면 생성
        if (retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitClient!!
    }
}