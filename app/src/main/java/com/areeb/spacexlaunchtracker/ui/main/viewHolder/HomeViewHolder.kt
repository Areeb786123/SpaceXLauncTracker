package com.areeb.spacexlaunchtracker.ui.main.viewHolder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.areeb.spacexlaunchtracker.databinding.ItemSpaceListBinding
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.utils.extensionFunction.toCustomDateFormat
import com.bumptech.glide.Glide

class HomeViewHolder(private val binding: ItemSpaceListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(item: SpaceXListResponse) {
        with(binding) {
            tvMissionDate.text = item.launch_date_local.toCustomDateFormat()
            tvMissionName.text = item.mission_name
            tvRocketName.text = item.rocket.rocket_name
            Glide.with(binding.root).load(item.links.mission_patch).into(binding.imgRocket)
        }
    }
}