package com.example.quipperandroidtest.Views

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_detail)

        val videoItem = intent.getParcelableExtra<PlaylistDataModel>("videoItem")
        videoItem?.let {
            titleTextView.text = it.title
            presenterTextView.text = it.presenter_name
            durationTextView.text = it.title
            descriptionTextView.text = it.description
            Picasso.get().load(it.thumbnail_url).into(thumbnailImageView)
        }
    }
}