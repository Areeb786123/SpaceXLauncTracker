package com.areeb.spacexlaunchtracker.ui.fav.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.databinding.FragmentFavBinding
import com.areeb.spacexlaunchtracker.domain.models.entitiy.SpaceEntity
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.ui.common.fragment.BaseFragment
import com.areeb.spacexlaunchtracker.ui.detailScreen.screen.DetailFragmentDirections
import com.areeb.spacexlaunchtracker.ui.fav.viewModel.FavViewModel
import com.areeb.spacexlaunchtracker.ui.main.adapter.HomeAdapter
import com.areeb.spacexlaunchtracker.ui.main.screens.HomeFragmentDirections
import com.areeb.spacexlaunchtracker.ui.main.viewModel.HomeViewModel
import com.areeb.spacexlaunchtracker.utils.extensionFunction.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavFragment : BaseFragment() {
    private var _binding: FragmentFavBinding? = null
    private val binding get() = _binding!!
    private val homeVm by activityViewModels<HomeViewModel>()
    private val viewModel by viewModels<FavViewModel>()

    private val adapter by lazy {
        HomeAdapter(onClick = { data, isFav ->
            if (!isFav) {
                homeVm.setCurrentMission(data, true)
                navigate(
                    FavFragmentDirections.actionFavFragmentToDetailFragment(),
                    R.id.detailFragment
                )
            } else {
                viewModel.removeFav(SpaceEntity(rocket = data))
                showToast("deleted ")
                viewModel.populateList()
            }
        }, true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavBinding.inflate(layoutInflater)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackKeyPress(FavFragmentDirections.actionFavFragmentToHomeFragment(), R.id.homeFragment)
        setRecyclerView()
        observer()
    }

    private fun observer() {
        viewModel.favXList.observe(viewLifecycleOwner) {
            val data = mutableListOf<SpaceXListResponse>()
            data.clear()
            it.forEach { sp ->
                data.add(sp.rocket)
            }
            adapter.setData(data)
        }
    }

    private fun setRecyclerView() {
        binding.rvFav.adapter = adapter
    }


    companion object {
        private const val TAG = "favFragment"
    }
}