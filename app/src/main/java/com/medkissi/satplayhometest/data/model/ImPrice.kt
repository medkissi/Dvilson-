package com.medkissi.satplayhometest.data.model

data class ImPrice(
    val attributes: Attributes,
    val label: String
){
    data class Attributes(
        val amount: String,
        val currency: String
    )
}