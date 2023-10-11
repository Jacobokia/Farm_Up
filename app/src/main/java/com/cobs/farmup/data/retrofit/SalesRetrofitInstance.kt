package com.cobs.farmup.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SalesRetrofitInstance {
    fun createSalesService(): SalesService{
        val retrofit = Retrofit.Builder().baseUrl("https://ivansfarm.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(SalesService::class.java)
        return service
    }
}