package com.example.quipperandroidtest.Models.DataModel;

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaylistDataModel(
    val title: String?,
    val presenter_name: String?,
    val description: String?,
    val thumbnail_url: String?,
    val video_url: String?,
    val video_duration: Long
): Parcelable