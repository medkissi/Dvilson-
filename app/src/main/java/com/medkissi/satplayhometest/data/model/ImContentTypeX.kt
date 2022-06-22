package com.medkissi.satplayhometest.data.model

data class ImContentTypeX(
    val attributes: Attributes
){
    data class Attributes(
        val label: String,
        val term: String
    )
}