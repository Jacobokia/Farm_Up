package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.PurchasesResponse
import retrofit2.http.GET

interface PurchasesService {

    @GET("get_purchases.php")
    suspend fun getPurchases():PurchasesResponse
}