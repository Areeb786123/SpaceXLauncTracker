package com.areeb.spacexlaunchtracker.ui.main.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.areeb.spacexlaunchtracker.databinding.ItemSpaceListBinding
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.ui.main.viewHolder.HomeViewHolder

class HomeAdapter(private val onClick: (SpaceXListResponse) -> Unit) :
    RecyclerView.Adapter<HomeViewHolder>() {

    val spaceList = mutableListOf<SpaceXListResponse>()
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
        holder.bind(spaceList[position], onClick)
    }
}