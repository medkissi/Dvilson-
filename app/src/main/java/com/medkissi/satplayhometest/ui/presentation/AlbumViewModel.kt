package com.medkissi.satplayhometest.ui.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medkissi.satplayhometest.data.repository.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val repository: AlbumRepository):ViewModel(){


    private val _state = mutableStateOf(AlbumScreenState(listOf(),isLoading = true))
    val state: State<AlbumScreenState>  get() = _state

    private val errorHandler =CoroutineExceptionHandler{_, exception->
        exception.printStackTrace()
        _state.value =_state.value.copy(
            error = exception.message.toString(),
            isLoading = false
        )
    }


    init {
        getAlbums()
    }

    fun getAlbums(){
        viewModelScope.launch(errorHandler) {
            val albums  = repository.getTopAlbums()
            _state.value =_state.value.copy(
                albums =albums,
                isLoading = false
            )
        }

    }
}