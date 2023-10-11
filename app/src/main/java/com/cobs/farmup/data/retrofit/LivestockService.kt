package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.LivestockResponse
import retrofit2.http.GET

interface LivestockService {

    @GET("get_animals.php")
    suspend fun getLivestock():LivestockResponse
}