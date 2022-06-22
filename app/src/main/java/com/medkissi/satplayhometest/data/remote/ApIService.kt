package com.medkissi.satplayhometest.data.remote

import com.medkissi.satplayhometest.data.model.Feed

interface ApIService {

    suspend fun getAlbum():Feed

}