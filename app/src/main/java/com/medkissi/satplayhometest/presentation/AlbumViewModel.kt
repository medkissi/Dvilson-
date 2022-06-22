package com.medkissi.satplayhometest.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medkissi.satplayhometest.data.model.Entry
import com.medkissi.satplayhometest.data.repository.AlbumRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val repository: AlbumRepository):ViewModel(){
    private  val TAG = "AlbumViewModel"

    val state = mutableStateOf(emptyList<Entry>())
    init {
        getAlbums()
    }

    fun getAlbums(){
        viewModelScope.launch {
            val albums  = repository.getTopAlbums()
            state.value = albums
        }

    }
}