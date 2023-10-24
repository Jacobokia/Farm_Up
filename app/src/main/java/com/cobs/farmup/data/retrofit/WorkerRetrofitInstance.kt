package com.cobs.farmup.data.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class WorkerRetrofitInstance{

    companion object{
        val baseUrl = "https://ivansfarm.000webhostapp.com/api/"
    }
    fun createWorkerService(): WorkerService{
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .client(clientOKHTTP())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Log.d("worker retro", "retrofit instance")
        val service = retrofit.create(WorkerService::class.java)
        return service
    }

    private fun clientOKHTTP(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

}