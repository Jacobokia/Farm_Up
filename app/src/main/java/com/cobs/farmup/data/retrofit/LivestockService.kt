package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.LivestockResponse
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface LivestockService {

    @GET("get_animals.php")
    suspend fun getLivestock():LivestockResponse

    @POST("insert_animal.php")
    suspend fun insertLivestock(
        @Field("tag_number")tag_number:String,
        @Field("name")name:String,
        @Field("type")type:String,
        @Field("breed")breed:String,
        @Field("image")image:String,
        @Field("age")age:String,
        @Field("gender")gender:String,
        @Field("weight")weight:String,
        @Field("color")color:String
    ):LivestockResponse
}