package com.areeb.spacexlaunchtracker.ui.main.viewHolder

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.areeb.spacexlaunchtracker.databinding.ItemSpaceListBinding
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.utils.extensionFunction.gone
import com.areeb.spacexlaunchtracker.utils.extensionFunction.toCustomDateFormat
import com.areeb.spacexlaunchtracker.utils.extensionFunction.visible
import com.bumptech.glide.Glide
import dagger.hilt.android.qualifiers.ApplicationContext

class HomeViewHolder(private val binding: ItemSpaceListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(
        item: SpaceXListResponse,
        onClick: (SpaceXListResponse, Boolean) -> Unit,
        colorList: List<String>,
        showFav: Boolean
    ) {
        with(binding) {
            tvMissionDate.text = item.launch_date_local.toCustomDateFormat()
            tvMissionName.text = item.mission_name
            tvRocketName.text = item.rocket.rocket_name
            Glide.with(binding.root).load(item.links.mission_patch).into(binding.imgRocket)
            card.setOnClickListener {
                onClick.invoke(item, false)
            }

            if (!showFav) {
                binding.btnSave.visible()
                binding.btnDelete.gone()
            } else {
                binding.btnSave.gone()
                binding.btnDelete.visible()
            }
            card.setCardBackgroundColor(Color.parseColor(colorList[adapterPosition % 7]))
            btnSave.setOnClickListener {
                onClick.invoke(item, true)
            }

            btnDelete.setOnClickListener {
                onClick.invoke(item, true)
            }
        }
    }
}