package com.example.quipperandroidtest.Repositories

import com.example.quipperandroidtest.Models.DataModel.PlaylistDataModel
import com.example.quipperandroidtest.Service.PlaylistDataService
import javax.inject.Inject

class PlaylistDataRepository @Inject constructor(private val apiService: PlaylistDataService) {
    suspend fun fetchVideos(): List<PlaylistDataModel> = apiService.getVideos()
}