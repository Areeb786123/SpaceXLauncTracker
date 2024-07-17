package com.areeb.spacexlaunchtracker.ui.main.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.databinding.FragmentHomeBinding
import com.areeb.spacexlaunchtracker.domain.repoImp.HomeRepoImp
import com.areeb.spacexlaunchtracker.ui.main.adapter.HomeAdapter
import com.areeb.spacexlaunchtracker.ui.main.viewModel.HomeViewModel
import com.areeb.spacexlaunchtracker.utils.extensionFunction.gone
import com.areeb.spacexlaunchtracker.utils.extensionFunction.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val viewModels by viewModels<HomeViewModel>()
    private val binding get() = _binding!!
    private val adapter by lazy {
        HomeAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        observer()
    }


    private fun observer() {
        viewModels.isLoading.observe(viewLifecycleOwner) {
            Log.e(TAG, it.toString())
            with(binding) {
                rvSpaceList.gone()
                progress.visible()

            }
        }
        viewModels.spaceXList.observe(viewLifecycleOwner) {
            Log.e(TAG, it.toString())
            with(binding) {
                rvSpaceList.visible()
                progress.gone()

            }
            adapter.setData(it)
        }
    }

    private fun setRecyclerView() {
        binding.rvSpaceList.adapter = adapter
    }

    companion object {
        private const val TAG = "homeFragment"
    }
}