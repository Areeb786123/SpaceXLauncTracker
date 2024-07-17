package com.areeb.spacexlaunchtracker.ui.detailScreen.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.areeb.spacexlaunchtracker.MainActivity
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.ui.common.fragment.BaseFragment
import com.areeb.spacexlaunchtracker.ui.main.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.function.LongFunction

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    private val viewModel by activityViewModels<HomeViewModel>()
    private val mainActivity by lazy { (activity as MainActivity) }
    private val currentMission by lazy {
        viewModel.currentMission.value
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Handle back press
        onBackKeyPress()
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, currentMission.toString())
    }

    private fun onBackKeyPress() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Navigate back to HomeFragment

                    navigate(
                        DetailFragmentDirections.actionDetailFragmentToHomeFragment(),
                        R.id.homeFragment
                    )
                }
            })
    }

    companion object {
        private const val TAG = "detailScreen"
    }


}