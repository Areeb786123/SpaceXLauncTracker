package com.areeb.spacexlaunchtracker.utils.extensionFunction

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
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

fun View.showKeyboard(delay: Long = 200L) {
    val context = this.context ?: return
    this.postDelayed(
        focusNotFound@{
            val focus = this.findFocus() ?: return@focusNotFound
            val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(focus, 0)
        },
        delay,
    )
}

fun View.hideKeyboard() {
    val context = this.context ?: return
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}




