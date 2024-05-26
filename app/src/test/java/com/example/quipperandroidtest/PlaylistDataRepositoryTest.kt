package com.example.quipperandroidtest

import com.example.quipperandroidtest.Models.DataModel.PlaylistDataModel
import com.example.quipperandroidtest.Repositories.PlaylistDataRepository
import com.example.quipperandroidtest.Service.PlaylistDataService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class VideoRepositoryTest {

    @Mock
    private lateinit var videoApiService: PlaylistDataService

    private lateinit var videoRepository: PlaylistDataRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        videoRepository = PlaylistDataRepository(videoApiService)
    }

    @Test
    fun `fetchVideos should return list of videos`() = runBlocking {
        val mockVideos = listOf(
            PlaylistDataModel(
                title = "G12 Chemistry",
                presenter_name = "Kaoru Sakata",
                description = "90 seconds exercise for Chemistry",
                thumbnail_url = "https://quipper.github.io/native-technical-exam/images/sakata.jpg",
                video_url = "https://quipper.github.io/native-technical-exam/videos/sakata.mp4",
                video_duration = 97000
            )
        )
        Mockito.`when`(videoApiService.getVideos()).thenReturn(mockVideos)

        val result = videoRepository.fetchVideos()

        assertEquals(mockVideos, result)
    }
}