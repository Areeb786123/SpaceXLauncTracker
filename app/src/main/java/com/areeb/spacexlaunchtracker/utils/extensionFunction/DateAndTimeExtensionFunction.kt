package com.areeb.spacexlaunchtracker.utils.extensionFunction

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun String.toCustomDateFormat(): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
    val outputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH)
    val date = LocalDateTime.parse(this, inputFormatter)
    return date.format(outputFormatter)
}