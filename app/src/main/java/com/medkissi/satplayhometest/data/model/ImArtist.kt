package com.medkissi.satplayhometest.data.model

data class ImArtist(
    val attributes: Attributes,
    val label: String
){
    data class Attributes(
        val href: String
    )
}