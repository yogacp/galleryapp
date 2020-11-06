package com.utsman.abstraction.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Yoga C. Pranata on 05/11/2020.
 * Android Engineer
 */
inline fun <reified T : ViewBinding> ViewGroup.viewBinding() = ViewBindingDelegate(T::class.java)

class ViewBindingDelegate<T : ViewBinding>(
    private val bindingClass: Class<T>
) : ReadOnlyProperty<ViewGroup, T> {
    private var binding: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): T {
        binding?.let { return it }

        /**
         * Inflate view class
         */
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java)

        /**
         * Bind layout
         */
        val invoke = inflateMethod.invoke(null, LayoutInflater.from(thisRef.context), thisRef) as T

        return invoke.also { this.binding = it }
    }
}