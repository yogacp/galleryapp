package com.utsman.abstraction.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.utsman.abstraction.adapter.GeneralAdapter

infix fun ViewGroup.inflate(layoutResId: Int): View = LayoutInflater.from(context).inflate(layoutResId, this, false)

fun Context.toast(msg: String?, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, msg, duration).show()

fun View.setVisibleIf(condition: Boolean) {
    visibility = if (condition) View.VISIBLE else View.GONE
}

fun <T: ViewBinding, ITEM> RecyclerView.setup(
    items: List<ITEM>,
    bindingClass: Class<T>,
    bindHolder: View.(T, ITEM) -> Unit,
    itemClick: View.(ITEM) -> Unit = {},
    manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
): GeneralAdapter<T, ITEM> {
    val generalAdapter by lazy {
        GeneralAdapter(items, bindingClass,
            { binding: T, item: ITEM ->
                bindHolder(binding, item)
            }, {
                itemClick(it)
            }
        )
    }

    layoutManager = manager
    adapter = generalAdapter
    (adapter as GeneralAdapter<*, *>).notifyDataSetChanged()

    return generalAdapter
}