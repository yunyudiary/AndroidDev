package com.jiangyy.android.dev

import android.app.Application
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatDelegate
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

private lateinit var INSTANCE: Application

abstract class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(0)
            .methodOffset(5)
            .tag("我要看输出")
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}

object AppContext : ContextWrapper(INSTANCE)