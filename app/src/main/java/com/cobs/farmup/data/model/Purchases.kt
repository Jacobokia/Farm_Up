package com.cobs.farmup.data.model


data class PurchasesResponse(
    val errorCode:Int,
    val message:String,
    val response:List<Purchases>
)
data class Purchases(
    var id: String,
    var product: String,
    var price: String,
    var quantity: String,
    var description: String,
    var purchased_from: String,
    var purchased_on: String
)
