package com.cobs.farmup.data.retrofit

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class LivestockRetrofitInstance {

    companion object{
        val baseUrl = "https://ivansfarm.000webhostapp.com/api/"
    }
    fun createLivestockService(): LivestockService{
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(LivestockService::class.java)
        return service
    }

}