package com.medkissi.satplayhometest.data.model

import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("entry")
    val entry: List<Entry>
)