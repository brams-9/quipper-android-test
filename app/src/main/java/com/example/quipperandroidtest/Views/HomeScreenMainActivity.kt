package com.example.quipperandroidtest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quipperandroidtest.ViewModels.PlaylistViewModel
import com.example.quipperandroidtest.Views.PlaylistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreenMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val playlistViewModel: PlaylistViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.videoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PlaylistAdapter(this)
        recyclerView.adapter = adapter

        playlistViewModel.videos.observe(this, Observer { videos ->
            videos?.let { adapter.setVideos(it) }
        })
    }
}