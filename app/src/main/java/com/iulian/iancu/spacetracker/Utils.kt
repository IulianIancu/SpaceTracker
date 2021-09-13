package com.iulian.iancu.spacetracker

import java.text.SimpleDateFormat
import java.util.*

fun getFormattedDateFromUTC(epoch: Long?): String {
    if (epoch == null) return ""
    val sdf = SimpleDateFormat("dd, MMM yyyy hh:mm:ss a", Locale.getDefault())
    return sdf.format(Date(epoch * 1000))
}