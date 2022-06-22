package com.medkissi.satplayhometest.data.model

data class ImContentType(
    val attributes: Attributes,
    val imContentType: ImContentTypeX
){
    data class Attributes(
        val label: String,
        val term: String
    )
}