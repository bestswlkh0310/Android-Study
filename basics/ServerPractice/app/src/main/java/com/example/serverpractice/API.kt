package com.example.serverpractice

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("members")
    fun getUser(): Call<String>
}