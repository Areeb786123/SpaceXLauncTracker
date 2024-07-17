package com.areeb.spacexlaunchtracker.ui.intro.screen

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.databinding.FragmentHomeBinding
import com.areeb.spacexlaunchtracker.databinding.FragmentIntroBinding
import com.areeb.spacexlaunchtracker.utils.extensionFunction.visible
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentIntroBinding.inflate(layoutInflater)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() {
        // Load the animation
        lifecycleScope.launch {
            delay(1000)
            animateButton()
        }
    }

    private fun animateButton() {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_up)
        // Start the animation
        binding.btnIntro.startAnimation(animation)
        binding.btnIntro.visible()
    }

    companion object {
        private const val TAG = "IntroFragment"
    }
}