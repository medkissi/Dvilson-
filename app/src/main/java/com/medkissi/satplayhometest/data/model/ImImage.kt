package com.medkissi.satplayhometest.data.model

data class ImImage(
    val attributes: Attributes,
    val label: String
){
    data class Attributes(
        val height: String
    )
}