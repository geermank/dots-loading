package com.geermank.dots.dot

import androidx.annotation.ColorRes
import com.geermank.dots.utils.ViewSize

const val NO_COLOR = -1

internal data class DotSpecs(
    var dotSize: ViewSize = ViewSize(0, 0),
    @ColorRes var dotColor: Int = NO_COLOR
) {

    fun getWidth() = dotSize.width
    fun getHeight() = dotSize.height

    fun colorCanBeDrawn() = dotColor != NO_COLOR
}