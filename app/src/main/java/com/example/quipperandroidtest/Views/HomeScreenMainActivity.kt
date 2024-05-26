package com.example.quipperandroidtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quipperandroidtest.Views.PlaylistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreenMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.videoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PlaylistAdapter()
        recyclerView.adapter = adapter
    }
}