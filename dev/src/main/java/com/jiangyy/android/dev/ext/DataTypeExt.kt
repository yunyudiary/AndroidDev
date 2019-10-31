package com.jiangyy.android.dev.ext

inline fun Int?.orZero(): Int = this ?: 0

inline fun String?.orZero(): String = if (this.isNullOrEmpty()) "0" else this

inline fun CharSequence?.orEmptyCharSequence(): CharSequence = this ?: ""

inline fun Boolean.toInt(): Int = if (this) 1 else 0