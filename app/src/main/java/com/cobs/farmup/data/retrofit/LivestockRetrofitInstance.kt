package com.cobs.farmup.data.retrofit

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LivestockRetrofitInstance {
    fun createLivestockService(): LivestockService{
        val retrofit = Retrofit.Builder().baseUrl("https://ivansfarm.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(LivestockService::class.java)
        return service
    }
}