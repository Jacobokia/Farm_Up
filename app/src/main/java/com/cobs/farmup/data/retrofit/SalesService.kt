package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.Sales
import com.cobs.farmup.data.model.SalesResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface SalesService {
    @GET("get_sales.php")
    suspend fun getSales(): SalesResponse


    @FormUrlEncoded
    @POST("sell_animal.php")
    suspend fun makeSales(
        @Field("animal_id") animal_id: String,
        @Field("price") price: String,
        @Field("quantity") quantity: String,
        @Field("sold_by") sold_by: String,
        @Field("sold_to") sold_to: String

    ):SalesResponse
}