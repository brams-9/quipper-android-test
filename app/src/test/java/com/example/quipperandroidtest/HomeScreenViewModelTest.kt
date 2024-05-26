package com.example.quipperandroidtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.quipperandroidtest.Models.DataModel.PlaylistDataModel
import com.example.quipperandroidtest.Repositories.PlaylistDataRepository
import com.example.quipperandroidtest.ViewModels.PlaylistViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class VideoViewModelTest {

    @get:Rule
    val instantTaskExecutorRule =
        InstantTaskExecutorRule()

    @Mock
    private lateinit var videoRepository: PlaylistDataRepository

    @Mock
    private lateinit var observer: Observer<List<PlaylistDataModel>>

    private lateinit var homeScreenViewModel: PlaylistViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        homeScreenViewModel = PlaylistViewModel(videoRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `videos LiveData should fetch and return videos`() = runBlockingTest {
        // Given
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
        Mockito.`when`(videoRepository.fetchVideos()).thenReturn(mockVideos)

        // When
        homeScreenViewModel.videos.observeForever(observer)
        testDispatcher.advanceUntilIdle()

        // Then
        Mockito.verify(observer).onChanged(mockVideos)
        homeScreenViewModel.videos.removeObserver(observer)
    }
}