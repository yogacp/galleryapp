package com.utsman.abstraction.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.signature.ObjectKey

fun ImageView.loadUrl(
    url: String?,
    id: String,
    requestListener: RequestListener<Drawable>? = null,
    placeholder: Drawable? = null
) = run {
    val sign = ObjectKey(id)
    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade(200))
        .addListener(requestListener)
        .placeholder(placeholder)
        .signature(sign)
        .into(this)
        .clearOnDetach()
}

fun ImageView.loadRes(
    @DrawableRes res: Int,
    id: String,
    requestListener: RequestListener<Drawable>? = null,
    placeholder: Drawable? = null
) = run {
    val sign = ObjectKey(id)
    Glide.with(context)
        .load(res)
        .transition(DrawableTransitionOptions.withCrossFade(200))
        .addListener(requestListener)
        .placeholder(placeholder)
        .signature(sign)
        .into(this)
        .clearOnDetach()
}
