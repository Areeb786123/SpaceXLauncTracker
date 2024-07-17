package com.areeb.spacexlaunchtracker.ui.main.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.databinding.FragmentHomeBinding
import com.areeb.spacexlaunchtracker.domain.repoImp.HomeRepoImp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    @Inject
    lateinit var homeRepoImp: HomeRepoImp
    private val binding get() = _binding
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
        lifecycleScope.launch {
            homeRepoImp.getSpaceXList()
        }
    }


    companion object {
        private const val TAG = "homeFragment"
    }
}