package com.example.quipperandroidtest.Views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quipperandroidtest.Models.DataModel.PlaylistDataModel
import com.example.quipperandroidtest.R
import com.squareup.picasso.Picasso

class PlaylistAdapter : RecyclerView.Adapter<PlaylistAdapter.VideoViewHolder>() {

    private var videoList = listOf<PlaylistDataModel>()

    fun setVideos(videos: List<PlaylistDataModel>) {
        videoList = videos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videoList[position]
        holder.bind(video)
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val presenterTextView: TextView = itemView.findViewById(R.id.presenterTextView)
        private val durationTextView: TextView = itemView.findViewById(R.id.durationTextView)
        private val thumbnailImageView: ImageView = itemView.findViewById(R.id.thumbnailImageView)

        fun bind(video: PlaylistDataModel) {
            titleTextView.text = video.title
            presenterTextView.text = video.presenter_name
            durationTextView.text = formatDuration(video.video_duration)
            Picasso.get().load(video.thumbnail_url).into(thumbnailImageView)
        }

        private fun formatDuration(duration: Long): String {
            val minutes = duration / 60000
            val seconds = (duration % 60000) / 1000
            return "${minutes} minutes ${seconds} seconds"
        }
    }
}