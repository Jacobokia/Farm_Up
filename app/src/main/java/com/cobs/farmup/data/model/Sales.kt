package com.cobs.farmup.data.model

data class SalesResponse(
    val errorCode:Int,
    val message:String,
    val response:List<Sales>
)

data class Sales(
    var id: String,
    var animal_id: String,
    var price: String,
    var quantity: String,
    var sold_by: String,
    var sold_to: String,
    var selling_date: String
)
