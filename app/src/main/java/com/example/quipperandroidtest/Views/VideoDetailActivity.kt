package com.example.quipperandroidtest.Views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quipperandroidtest.Models.DataModel.PlaylistDataModel
import com.example.quipperandroidtest.R
import com.squareup.picasso.Picasso


class VideoDetailActivity : AppCompatActivity() {

    private val titleTextView: TextView = findViewById(R.id.titleTextView)
    private val presenterTextView: TextView = findViewById(R.id.presenterTextView)
    private val durationTextView: TextView = findViewById(R.id.durationTextView)
    private val thumbnailImageView: ImageView = findViewById(R.id.thumbnailImageView)
    private val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
    private val videoPlayerButton: Button = findViewById(R.id.watchVideoButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_detail)

        val videoItem = intent.getParcelableExtra<PlaylistDataModel>("videoItem")
        videoItem?.let {
            titleTextView.text = it.title
            presenterTextView.text = it.presenter_name
            durationTextView.text = formatDuration(it.video_duration)
            descriptionTextView.text = it.description
            Picasso.get().load(it.thumbnail_url).into(thumbnailImageView)

            val videoUrl: String? = it.video_url
            videoPlayerButton.setOnClickListener {
                val intent = Intent(this, VideoPlayerActivity::class.java).apply {
                    putExtra("videoUrl", videoUrl)
                }
                startActivity(intent)
            }
        }


    }

    private fun formatDuration(duration: Long): String {
        val minutes = duration / 60000
        val seconds = (duration % 60000) / 1000
        return "${minutes} minutes ${seconds} seconds"
    }
}