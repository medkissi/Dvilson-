package com.medkissi.satplayhometest.ui.presentation

import com.medkissi.satplayhometest.data.model.Entry

data class AlbumScreenState(
    val albums: List<Entry>,
    val isLoading: Boolean,
    val error: String? = null
)