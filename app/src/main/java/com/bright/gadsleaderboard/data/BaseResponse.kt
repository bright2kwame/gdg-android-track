package com.bright.gadsleaderboard.data

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("count")
    var count: String = "",
    @SerializedName("result")
    var result: Double = 0.0
)