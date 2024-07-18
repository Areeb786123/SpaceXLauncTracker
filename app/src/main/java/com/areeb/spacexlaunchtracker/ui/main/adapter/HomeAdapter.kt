package com.areeb.spacexlaunchtracker.ui.main.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.databinding.ItemSpaceListBinding
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.ui.main.viewHolder.HomeViewHolder

class HomeAdapter(private val onClick: (SpaceXListResponse, Boolean) -> Unit) :
    RecyclerView.Adapter<HomeViewHolder>() {

    private val spaceList = mutableListOf<SpaceXListResponse>()
    private val colorList =
        listOf("#E7B5AB", "#E2E7AB", "#9AC6CE", "#9ACEA2", "#B89ACE", "#CE9A9A", "#9AB9CE")

    fun setData(list: List<SpaceXListResponse>) {
        spaceList.clear()
        spaceList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemSpaceListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return spaceList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(spaceList[position], onClick, colorList, spaceList.size)
    }
}