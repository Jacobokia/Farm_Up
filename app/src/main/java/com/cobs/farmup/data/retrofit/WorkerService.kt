package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.Worker
import com.cobs.farmup.data.model.WorkerResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WorkerService {
    @GET("get_users.php")
    suspend fun getUsers():WorkerResponse
    @FormUrlEncoded
    @GET("login.php")
    suspend fun loginUsers(
        @Field("phone")phone: String,
        @Field("password")password: String
    )

    @FormUrlEncoded
    @POST("insert_user.php")
    suspend fun insertUsers(
        @Field("f_name")f_name:String,
        @Field("l_name")l_name:String,
        @Field("title")title: String,
        @Field("phone")phone: String,
        @Field("password")password: String,
        @Field("gender")gender: String

    ):WorkerResponse

}