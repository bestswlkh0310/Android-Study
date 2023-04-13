package com.example.apipractice.movieApi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("boxOfficeResult")
    @Expose // => json
    var boxOfficeResult: BoxOfficeResult? = null
}