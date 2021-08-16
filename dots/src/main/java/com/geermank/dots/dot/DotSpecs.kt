package com.geermank.dots.dot

import com.geermank.dots.utils.ViewSize

internal data class DotSpecs(
    var dotSize: ViewSize
) {

    fun getWidth() = dotSize.width
    fun getHeight() = dotSize.height
}