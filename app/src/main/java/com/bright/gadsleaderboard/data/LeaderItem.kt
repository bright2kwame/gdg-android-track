package com.bright.gadsleaderboard.data

import com.google.gson.annotations.SerializedName

data class LeaderItem(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("first_name")
    var firstName: String = "",
    @SerializedName("last_name")
    var lastName: String = "",
    @SerializedName("duration")
    var duration: String = "",
    @SerializedName("country")
    var country: String = ""
)