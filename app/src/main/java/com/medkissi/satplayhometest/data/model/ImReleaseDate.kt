package com.medkissi.satplayhometest.data.model

data class ImReleaseDate(
    val attributes: Attributes,
    val label: String
){
    data class Attributes(
        val label: String
    )
}