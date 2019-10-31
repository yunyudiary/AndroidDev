package com.jiangyy.android.dev.ext

import com.google.gson.Gson
import com.orhanobut.logger.Logger

inline fun <reified T> T.logJson() = Logger.json(this.toJsonStr())

inline fun <reified T> T.toJsonStr() = Gson().toJson(this)