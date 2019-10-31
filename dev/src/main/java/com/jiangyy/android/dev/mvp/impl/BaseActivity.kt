package com.jiangyy.android.dev.mvp.impl

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindLayout())
        initWidget()
        initData()
    }

    @LayoutRes
    abstract fun bindLayout(): Int

    open fun initData() {}

    open fun initWidget() {}

}