package com.example.todoapplication.util

import java.text.SimpleDateFormat
import java.util.Date


fun String.timestampStringtodate(): String {
    val timestampLong = this.toLong()
    val date = Date(timestampLong)
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(date)

}

fun String.dateStringToTimestamp(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    val date = dateFormat.parse(this)
    return date.time.toString()

}

