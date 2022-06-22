package com.medkissi.satplayhometest.data.model

data class Link(
    val attributes: Attributes
){
    data class Attributes(
        val href: String,
        val rel: String,
        val type: String
    )
}