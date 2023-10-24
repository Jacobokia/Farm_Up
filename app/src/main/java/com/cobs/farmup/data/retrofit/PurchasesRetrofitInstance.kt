package com.cobs.farmup.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class PurchasesRetrofitInstance {
    companion object{
        val baseUrl = "https://ivansfarm.000webhostapp.com/api/"
    }

    fun createPurchaseService():PurchasesService{
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PurchasesService::class.java)
        return service
    }
}