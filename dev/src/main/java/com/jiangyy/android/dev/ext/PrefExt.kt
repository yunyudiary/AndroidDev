package com.jiangyy.android.dev.ext

import com.jiangyy.android.dev.AppContext
import kotlin.reflect.jvm.jvmName

inline fun <reified R, T> R.pref(default: T) = Preference(AppContext, "", default, R::class.jvmName)