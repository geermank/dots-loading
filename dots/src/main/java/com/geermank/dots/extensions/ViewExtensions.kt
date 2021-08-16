package com.geermank.dots.extensions

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat

fun View.setColorAsBackground(@ColorRes colorRes: Int) {
    background = ColorDrawable(getColor(colorRes))
}

fun View.getColor(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(context, colorRes)
}

fun View.getDimenPixelSize(@DimenRes dimenRes: Int): Int {
    return context.resources.getDimensionPixelSize(dimenRes)
}

fun Context.getDimenPixelSize(@DimenRes dimenRes: Int): Int {
    return resources.getDimensionPixelSize(dimenRes)
}