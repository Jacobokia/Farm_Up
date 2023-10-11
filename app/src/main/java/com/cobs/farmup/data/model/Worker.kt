package com.cobs.farmup.data.model


data class WorkerResponse(
    val responseCode: Int,
    val message: String,
    val response: List<Worker>
)

data class Worker(
    var id: String,
    var f_name: String,
    var l_name: String,
    var title: String,
    var phone: String,
    var image: String?,
    var password: String,
    var age: Int?
)
