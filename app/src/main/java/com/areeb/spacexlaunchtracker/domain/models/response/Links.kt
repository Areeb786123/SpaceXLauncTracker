package com.areeb.spacexlaunchtracker.domain.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(
    val article_link: String,
//    val flickr_images: List<Any>,
    val mission_patch: String,
    val mission_patch_small: String,
//    val presskit: Any,
//    val reddit_campaign: Any,
//    val reddit_launch: Any,
//    val reddit_media: Any,
//    val reddit_recovery: Any,
    val video_link: String,
    val wikipedia: String,
    val youtube_id: String
):Parcelable