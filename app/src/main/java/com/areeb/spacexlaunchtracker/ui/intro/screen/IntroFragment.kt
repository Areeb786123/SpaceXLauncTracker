package com.areeb.spacexlaunchtracker.ui.intro.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.databinding.FragmentIntroBinding
import com.areeb.spacexlaunchtracker.ui.common.fragment.BaseFragment
import com.areeb.spacexlaunchtracker.utils.extensionFunction.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class IntroFragment : BaseFragment() {

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
            delay(500)
            animateButton()
        }

        binding.btnIntro.setOnClickListener {
            navigate(IntroFragmentDirections.actionIntroFragmentToHomeFragment(), R.id.homeFragment)
        }
    }

    private fun animateButton() {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_up)
        // Create an animation listener
        val animationListener = object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Optional: Code to execute when the animation starts
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.btnIntro.visible()

            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Optional: Code to execute if the animation repeats (if applicable)
            }
        }
        animation.setAnimationListener(animationListener)
        // Start the animation
        binding.imgRocket.startAnimation(animation)
        binding.imgRocket.visible()


    }

    companion object {
        private const val TAG = "IntroFragment"
    }
}
