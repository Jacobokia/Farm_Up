package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.SalesResponse
import retrofit2.http.GET

interface SalesService {
 @GET("get_sales.php")
suspend fun getSales():SalesResponse
}