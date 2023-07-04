package com.health.extension

fun String.toIntOrZero(): Int = if (this.isEmpty()) 0 else this.toInt()
