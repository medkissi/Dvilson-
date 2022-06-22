package com.medkissi.satplayhometest.data.model

data class Id(
    val attributes: Attributes,
    val label: String
){
    data class Attributes(
        val imId: String
    )
}