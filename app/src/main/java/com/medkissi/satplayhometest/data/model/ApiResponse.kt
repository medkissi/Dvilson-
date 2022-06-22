package com.medkissi.satplayhometest.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("feed")
    val feed: Feed
)