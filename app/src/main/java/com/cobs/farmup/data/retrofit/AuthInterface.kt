package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.AuthResponseData
import com.cobs.farmup.data.model.WorkerResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthInterface {

    @FormUrlEncoded
    @POST("login.php")
    suspend fun loginUser(
        @Field("phone")phone: String,
        @Field("password")password: String
    ): AuthResponseData
}