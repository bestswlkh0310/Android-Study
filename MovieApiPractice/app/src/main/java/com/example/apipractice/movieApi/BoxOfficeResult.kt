package com.example.apipractice.movieApi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BoxOfficeResult {
    @SerializedName("boxofficeType")
    @Expose
    var boxofficeType: String? = null

    @SerializedName("showRange")
    @Expose
    var showRange: String? = null

    @SerializedName("dailyBoxOfficeList")
    @Expose
    var dailyBoxOfficeList: List<DailyBoxOfficeList>? = null
}