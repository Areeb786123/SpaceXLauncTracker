package com.areeb.spacexlaunchtracker.ui.main.screens

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.databinding.FragmentHomeBinding
import com.areeb.spacexlaunchtracker.domain.repoImp.HomeRepoImp
import com.areeb.spacexlaunchtracker.ui.common.fragment.BaseFragment
import com.areeb.spacexlaunchtracker.ui.main.adapter.HomeAdapter
import com.areeb.spacexlaunchtracker.ui.main.viewModel.HomeViewModel
import com.areeb.spacexlaunchtracker.utils.extensionFunction.gone
import com.areeb.spacexlaunchtracker.utils.extensionFunction.hide
import com.areeb.spacexlaunchtracker.utils.extensionFunction.hideKeyboard
import com.areeb.spacexlaunchtracker.utils.extensionFunction.showKeyboard
import com.areeb.spacexlaunchtracker.utils.extensionFunction.showToast
import com.areeb.spacexlaunchtracker.utils.extensionFunction.visible
import com.google.android.material.search.SearchView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : BaseFragment(), View.OnClickListener {
    private var _binding: FragmentHomeBinding? = null

    private val viewModels by activityViewModels<HomeViewModel>()
    private val binding get() = _binding!!
    private val adapter by lazy {
        HomeAdapter {
            viewModels.setCurrentMission(it)
            navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(),
                R.id.detailFragment
            )
        }
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
        search()
        setOnClickListener()
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


    private fun setOnClickListener() {
        binding.searchDisable.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v?.id) {
                searchDisable.id -> {
                    searchDisable.gone()
                    search.visible()
                    // Set focus to the SearchView and show the keyboard
                    binding.search.isIconified = false
                    binding.search.requestFocus()
                    search.showKeyboard()
                }

                else -> {

                }
            }
        }

    }

    private fun search() {
        binding.search.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModels.filterList(newText)
                    if (it.isNullOrEmpty()) {
                        binding.let { di ->
                            di.search.hide()
                            di.searchDisable.visible()
                            di.search.hideKeyboard()
                            viewModels.getAllSpaceXList()
                        }
                    }
                }
                return true
            }
        })
    }


}