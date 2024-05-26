package com.example.quipperandroidtest.Views

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.quipperandroidtest.R

class VideoPlayerActivity: AppCompatActivity() {

    private val videoView: VideoView = findViewById(R.id.videoView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val videoUrl = intent?.getStringExtra("videoUrl")
        videoUrl?.let {
            val uri = Uri.parse(it)
            videoView.setVideoURI(uri)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)
            videoView.start()
        } ?: run {
            finish()
        }
    }
}