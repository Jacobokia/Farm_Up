package com.cobs.farmup.data.model


data class LivestockResponse(
    val errorCode:Int,
    val message:String,
    val response:List<Livestock>
)
data class Livestock(
    var id: String,
    var name: String,
    var tag_number: String,
    var type: String,
    var breed: String,
    var image: String,
    var age: String,
    var gender: String,
    var weight: String,
    var available: String,
    var color: String
)
