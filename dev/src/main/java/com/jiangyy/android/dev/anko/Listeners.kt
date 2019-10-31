package com.jiangyy.android.dev.anko

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener

fun TextView.textChangedListener(init: __TextWatcher.() -> Unit) {
    val listener = __TextWatcher()
    listener.init()
    addTextChangedListener(listener)
}

class __TextWatcher : android.text.TextWatcher {

    private var _beforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        _beforeTextChanged?.invoke(s, start, count, after)
    }

    fun beforeTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _beforeTextChanged = listener
    }

    private var _onTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _onTextChanged?.invoke(s, start, before, count)
    }

    fun onTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _onTextChanged = listener
    }

    private var _afterTextChanged: ((android.text.Editable?) -> Unit)? = null

    override fun afterTextChanged(s: android.text.Editable?) {
        _afterTextChanged?.invoke(s)
    }

    fun afterTextChanged(listener: (android.text.Editable?) -> Unit) {
        _afterTextChanged = listener
    }

}

inline fun View.onClick(noinline l: (v: View?) -> Unit) {
    hideSoftInput()
    setOnClickListener(l)
}

inline fun View.onLongClick(noinline l: (v: View?) -> Boolean) {
    setOnLongClickListener(l)
}

inline fun RecyclerView.linearLayoutManager(
    @RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL, reverseLayout: Boolean = false
): RecyclerView =
    this.apply {
        this.layoutManager = LinearLayoutManager(this.context, orientation, reverseLayout)
    }

inline fun RecyclerView.gridLayoutManager(span: Int = 2): RecyclerView =
    this.apply {
        this.layoutManager = GridLayoutManager(this.context, span)
    }

inline fun RecyclerView.onItemClick(crossinline success: (Int) -> Unit) {
    this.addOnItemTouchListener(object : OnItemClickListener() {
        override fun onSimpleItemClick(
            adapter: BaseQuickAdapter<*, *>?,
            view: View?,
            position: Int
        ) {
            success(position)
        }
    })
}

inline fun RecyclerView.onItemLongClick(crossinline success: (Int) -> Unit) {
    this.addOnItemTouchListener(object : OnItemLongClickListener() {
        override fun onSimpleItemLongClick(
            adapter: BaseQuickAdapter<*, *>?,
            view: View?,
            position: Int
        ) {
            success(position)
        }
    })
}

inline fun RecyclerView.onItemChildClick(crossinline success: (Int, View?) -> Unit) {
    this.addOnItemTouchListener(object : OnItemChildClickListener() {
        override fun onSimpleItemChildClick(
            adapter: BaseQuickAdapter<*, *>?,
            view: View?,
            position: Int
        ) {
            success(position, view)
        }
    })
}