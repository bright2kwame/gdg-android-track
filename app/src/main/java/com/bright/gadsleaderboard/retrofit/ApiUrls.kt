package com.bright.gadsleaderboard.retrofit

import com.bright.gadsleaderboard.data.LeaderItem
import retrofit2.Call
import retrofit2.http.*

interface ApiUrls {
    @Headers("Content-Type: application/json")
    @GET("api/hours/")
    fun learningLeaders(): Call<List<LeaderItem>>

    @Headers("Content-Type: application/json")
    @GET("api/skilliq/")
    fun skillIQLeaders(): Call<List<LeaderItem>>


    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field(" entry.284483984") linkToProject: String
    ): Call<Void>

}