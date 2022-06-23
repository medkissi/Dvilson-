package com.medkissi.satplayhometest.data.model

import com.google.gson.annotations.SerializedName

data class Entry(
    val category: Category,
    val id: Id,
    @SerializedName("im:artist")
    val imArtist: ImArtist,
    @SerializedName("im:contentType")
    val imContentType: ImContentType,
    @SerializedName("im:image")
    val imImage: List<ImImage>,
    @SerializedName("im:itemCount")
    val imItemCount: ImItemCount,
    @SerializedName("im:name")
    val imName: ImName,
    @SerializedName("im:price")
    val imPrice: ImPrice,
    @SerializedName("im:releaseDate")
    val imReleaseDate: ImReleaseDate,
    val link: Link,
    val rights: Rights,
    val title: Title,
)