package com.cobs.farmup.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class WorkerResponse(
    val responseCode: Int,
    val message: String,
    val response: List<Worker>
)

@Entity(tableName = "Worker")
data class Worker(
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var f_name: String,
    var l_name: String,
    var title: String,
    var phone: String,
    var image: String?,
    var password: String,
    var age: Int?
)
