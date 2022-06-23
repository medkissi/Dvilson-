package com.medkissi.satplayhometest.data.remote

import com.medkissi.satplayhometest.data.model.ApiResponse
import com.medkissi.satplayhometest.data.model.Feed
import retrofit2.http.GET

interface ApIService {
    @GET("topalbums/limit=100/json")
    suspend fun getAlbums():ApiResponse

}