package com.medkissi.satplayhometest.data.model

data class Category(
    val attributes: Attributes
){
    data class Attributes(
        val imId: String,
        val label: String,
        val scheme: String,
        val term: String
    )
}