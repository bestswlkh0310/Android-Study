package com.example.apipractice.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance: RetrofitClient? = null
    private var retrofitInterface: RetrofitInterface? = null
    private const val baseUrl = "http://www.kobis.or.kr"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit.create(RetrofitInterface::class.java)
    }

    @Synchronized
    fun getInstance(): RetrofitClient {
        if (instance == null) {
            instance = RetrofitClient
        }
        return instance!!
    }

    fun getRetrofitInterface(): RetrofitInterface {
        return retrofitInterface!!
    }
}