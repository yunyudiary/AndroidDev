/*
 * Copyright 2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.jiangyy.android.dev.anko

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Context.toggleSoftInput() {
    inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun View.showSoftInput(): Boolean {
    return context.inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun Activity.showSoftInput(): Boolean {
    return currentFocus?.showSoftInput() ?: false
}

fun View.hideSoftInput(): Boolean {
    return context.inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.hideSoftInput(): Boolean {
    return currentFocus?.hideSoftInput() ?: false
}

fun Context.isActive(): Boolean {
    return inputMethodManager.isActive
}

fun Activity.finishWithResult(resultCode: Int = Activity.RESULT_OK) {
    setResult(Activity.RESULT_OK)
    this.finish()
}

inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
    AnkoInternals.internalStartActivity(this, T::class.java, params)

inline fun <reified T : Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) =
    AnkoInternals.internalStartActivity(requireActivity(), T::class.java, params)

inline fun <reified T : Activity> Activity.startActivityForResult(
    requestCode: Int,
    vararg params: Pair<String, Any?>
) =
    AnkoInternals.internalStartActivityForResult(this, T::class.java, requestCode, params)

inline fun <reified T : Activity> Fragment.startActivityForResult(
    requestCode: Int,
    vararg params: Pair<String, Any?>
) =
    AnkoInternals.internalStartActivityForResult(
        requireActivity(),
        T::class.java,
        requestCode,
        params
    )

inline fun <reified T : Service> Context.startService(vararg params: Pair<String, Any?>) =
    AnkoInternals.internalStartService(this, T::class.java, params)

inline fun <reified T : Service> Fragment.startService(vararg params: Pair<String, Any?>) =
    AnkoInternals.internalStartService(requireActivity(), T::class.java, params)

inline fun <reified T : Service> Context.stopService(vararg params: Pair<String, Any?>) =
    AnkoInternals.internalStopService(this, T::class.java, params)

inline fun <reified T : Service> Fragment.stopService(vararg params: Pair<String, Any?>) =
    AnkoInternals.internalStopService(requireActivity(), T::class.java, params)

inline fun <reified T : Any> Context.intentFor(vararg params: Pair<String, Any?>): Intent =
    AnkoInternals.createIntent(this, T::class.java, params)

inline fun <reified T : Any> Fragment.intentFor(vararg params: Pair<String, Any?>): Intent =
    AnkoInternals.createIntent(requireActivity(), T::class.java, params)

