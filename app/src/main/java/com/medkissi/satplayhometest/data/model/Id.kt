package com.medkissi.satplayhometest.data.model

import com.google.gson.annotations.SerializedName

data class Id(
    val attributes: Attributes,
    val label: String
){
    data class Attributes(
        @SerializedName("im:id")
        val imId: String
    )
}