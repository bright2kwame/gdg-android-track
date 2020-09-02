package com.bright.gadsleaderboard.data

import com.google.gson.annotations.SerializedName

data class LeaderItem(
    @SerializedName("name")
    var name: String = "",
    @SerializedName("score")
    var score: Int = 0,
    @SerializedName("country")
    var country: String = "",
    @SerializedName("badgeUrl")
    var badgeUrl: String = "",
    @SerializedName("hours")
    var hours: Int = 0
)