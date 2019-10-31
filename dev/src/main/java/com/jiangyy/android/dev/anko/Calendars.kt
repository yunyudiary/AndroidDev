package com.jiangyy.android.dev.anko

import android.widget.TextView
import com.jiangyy.android.dev.widget.CustomDatePicker
import java.text.SimpleDateFormat
import java.util.*

/**
 * Return the current time in milliseconds.
 * @return [Long] the current time in milliseconds
 */
inline fun getNowMills(): Long = Calendar.getInstance().timeInMillis

/**
 * Return the current formatted time string.
 * @param pattern [String] The pattern of date format, default: yyyy-MM-dd HH:mm:ss
 * @return [String] the current formatted time string
 */
inline fun getNowString(pattern: String = "yyyy-MM-dd HH:mm:ss"): String =
    Calendar.getInstance().timeInMillis.millis2String(pattern)

inline fun getNowString(pattern: String = "yyyy-MM-dd HH:mm:ss", from: Int): String =
    (Calendar.getInstance().timeInMillis + 24 * 60 * 60 * 1000 * from).millis2String(pattern)

/**
 * Return the current date.
 * @return [Date] the current date
 */
inline fun getNowDate(): Date = Date()

/**
 * Return the day of week in Chinese.
 * @receiver Date [Date] The date.
 * @return [String] the day of week in Chinese
 */
inline fun Date.getChineseWeek(): String = SimpleDateFormat("E", Locale.CHINA).format(this)

/**
 * Return the day of week in Chinese.
 * @receiver [String] The formatted time string.
 * @param pattern [String] The format.
 * @return [String] the day of week in Chinese
 */
inline fun String.getChineseWeek(pattern: String = "yyyy-MM-dd HH:mm:ss"): String =
    this.string2Date(pattern).getChineseWeek()

/**
 * Return the day of week in US.
 * @receiver [Long] The milliseconds.
 * @return [String] the day of week in Chinese
 */
inline fun Long.getUSWeek(): String = this.millis2Date().getChineseWeek()

/**
 * Return the day of week in US.
 * @receiver Date [Date] The date.
 * @return [String] the day of week in Chinese
 */
inline fun Date.getUSWeek(): String = SimpleDateFormat("EEEE", Locale.US).format(this)

/**
 * Return the day of week in US.
 * @receiver [String] The formatted time string.
 * @param pattern [String] The format.
 * @return [String] the day of week in Chinese
 */
inline fun String.getUSWeek(pattern: String = "yyyy-MM-dd HH:mm:ss"): String =
    this.string2Date(pattern).getChineseWeek()

/**
 * Return the day of week in Chinese.
 * @receiver [Long] The milliseconds.
 * @return [String] the day of week in Chinese
 */
inline fun Long.getChineseWeek(): String = this.millis2Date().getChineseWeek()

/**
 * Milliseconds to the formatted time string.
 * @receiver [Long] millis The milliseconds.
 * @param pattern [String] The pattern of date format, default: yyyy-MM-dd HH:mm:ss
 * @return [String] the formatted time string
 */
inline fun Long.millis2String(pattern: String = "yyyy-MM-dd HH:mm:ss"): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)

/**
 * Milliseconds to the date.
 * @receiver [Long] millis The milliseconds.
 * @return [Date] the date
 */
inline fun Long.millis2Date(): Date = Date(this)

/**
 * Formatted time string to the milliseconds.
 * @receiver [String] The formatted time string.
 * @param pattern [String] The pattern of date format, default: yyyy-MM-dd HH:mm:ss
 * @return [Long] the milliseconds
 */
inline fun String.string2Millis(pattern: String = "yyyy-MM-dd HH:mm:ss"): Long =
    SimpleDateFormat(pattern, Locale.getDefault()).parse(this).time

/**
 * Formatted time string to the date.
 * @receiver [String] The formatted time string.
 * @param pattern [String] The format.
 * @return [Date] the date
 */
inline fun String.string2Date(pattern: String = "yyyy-MM-dd HH:mm:ss"): Date =
    SimpleDateFormat(pattern, Locale.getDefault()).parse(this)

/**
 * Milliseconds to the date.
 * @receiver [Date] the date
 * @return [Long] the milliseconds
 */
inline fun Date.date2Millis(): Long = this.time

/**
 * Date to the formatted time string.
 * @receiver [Date] The date.
 * @param pattern [String] The pattern of date format, default: yyyy-MM-dd HH:mm:ss
 * @return [String] the formatted time string
 */
inline fun Date.date2String(pattern: String = "yyyy-MM-dd HH:mm:ss"): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)

fun TextView.getTimeDialog(
    startDate: String = "2000-01-01 00:00:00",
    onSuccess: (String) -> Unit
) {

    val beginTimestamp = startDate.string2Millis("yyyy-MM-dd HH:mm")
    val endTimestamp = "2050-12-31 23:59:59".string2Millis("yyyy-MM-dd HH:mm")

    CustomDatePicker(this.context, {
        this.text = it.millis2String("yyyy-MM-dd HH:mm")
        onSuccess(it.millis2String("yyyy-MM-dd HH:mm") + ":00")
    }, beginTimestamp, endTimestamp).apply {
        // 不允许点击屏幕或物理返回键关闭
        this.setCancelable(false)
        // 显示时和分
        this.setCanShowPreciseTime(true)
        // 不允许循环滚动
        this.setScrollLoop(false)
        // 不允许滚动动画
        this.setCanShowAnim(false)
    }.show(getNowString("yyyy-MM-dd HH:mm"))

}

fun TextView.getDateDialog(onSuccess: (String) -> Unit) {

    val beginTimestamp = "2000-01-01".string2Millis("yyyy-MM-dd")
    val endTimestamp = "2050-12-31".string2Millis("yyyy-MM-dd")

    CustomDatePicker(this.context, {
        this.text = it.millis2String("")
        onSuccess(it.millis2String("yyyy-MM-dd"))
    }, beginTimestamp, endTimestamp).apply {
        // 不允许点击屏幕或物理返回键关闭
        this.setCancelable(false)
        // 显示时和分
        this.setCanShowPreciseTime(false)
        // 不允许循环滚动
        this.setScrollLoop(false)
        // 不允许滚动动画
        this.setCanShowAnim(false)
    }.show(getNowString("yyyy-MM-dd"))

}