package com.cobs.farmup.data.retrofit

import com.cobs.farmup.data.model.Worker
import com.cobs.farmup.data.model.WorkerResponse
import retrofit2.http.GET

interface WorkerService {
    @GET("get_users.php")
    suspend fun getUsers():WorkerResponse
}