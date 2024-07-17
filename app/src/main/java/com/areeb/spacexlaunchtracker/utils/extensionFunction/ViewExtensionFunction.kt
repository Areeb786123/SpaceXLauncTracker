package com.areeb.spacexlaunchtracker.utils.extensionFunction

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun Context.showToast(text: String, type: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, type).show()
}

fun Fragment.showToast(text: String) {
    requireActivity().showToast(text)
}



