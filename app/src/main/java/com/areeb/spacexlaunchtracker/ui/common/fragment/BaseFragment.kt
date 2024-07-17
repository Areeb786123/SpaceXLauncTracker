package com.areeb.spacexlaunchtracker.ui.common.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

   open  fun navigate(
        direction: NavDirections, resId: Int,
        bundle: Bundle? = null,
    ) {
        findNavController().currentDestination?.getAction(direction.actionId)?.run {
            findNavController().navigate(resId, bundle)
        }
    }
}