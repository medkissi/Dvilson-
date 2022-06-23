package com.medkissi.satplayhometest.data.repository

import com.medkissi.satplayhometest.data.model.Entry
import com.medkissi.satplayhometest.data.remote.ApIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AlbumRepository @Inject constructor( private val api:ApIService) {


    suspend fun getTopAlbums():List<Entry>{
        return  withContext(Dispatchers.IO){
            api.getAlbums().feed.entry
        }
    }

}