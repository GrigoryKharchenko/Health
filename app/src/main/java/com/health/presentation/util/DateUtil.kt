package com.health.presentation.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtil {

    private const val PATTERN_DATE = "dd.MM.yyyy"

    fun getCurrentDate(): String = SimpleDateFormat(PATTERN_DATE, Locale.getDefault())
        .format(System.currentTimeMillis())
}
