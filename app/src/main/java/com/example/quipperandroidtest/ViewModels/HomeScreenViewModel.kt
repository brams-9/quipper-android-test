package com.example.quipperandroidtest.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.quipperandroidtest.Repositories.PlaylistDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(private val repository: PlaylistDataRepository) : ViewModel() {

    val videos = liveData(Dispatchers.IO) {
        val retrievedVideos = repository.fetchVideos()
        emit(retrievedVideos)
    }
}