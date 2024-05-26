package com.example.quipperandroidtest.Service

import com.example.quipperandroidtest.Models.DataModel.PlaylistDataModel
import retrofit2.http.GET

interface PlaylistDataService {
    @GET("playlist.json")
    suspend fun getVideos(): List<PlaylistDataModel>
}