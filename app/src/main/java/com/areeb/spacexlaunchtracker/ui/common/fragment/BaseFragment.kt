package com.areeb.spacexlaunchtracker.ui.common.fragment

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.areeb.spacexlaunchtracker.R

open class BaseFragment : Fragment() {

    open fun navigate(
        direction: NavDirections, resId: Int,
        bundle: Bundle? = null,
    ) {
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.anim_enter_right)
            .setExitAnim(R.anim.anim_enter_left)
            .setPopEnterAnim(R.anim.anim_enter_right)
            .setPopExitAnim(R.anim.anim_enter_left)
            .build()
        findNavController().currentDestination?.getAction(direction.actionId)?.run {
            findNavController().navigate(resId, bundle, navOptions)
        }
    }

    open fun onBackKeyPress(navDirections: NavDirections, id :Int) {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Navigate back to HomeFragment

                    navigate(
                        navDirections,
                        id
                    )
                }
            })
    }


}