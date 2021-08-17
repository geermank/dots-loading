package com.geermank.dots.utils

import kotlin.math.min

internal data class ViewSize(
    val width: Int,
    val height: Int
) {

    constructor(viewSizeInPixels: Int) : this(viewSizeInPixels, viewSizeInPixels)

    fun getSmallest(): Int {
        return min(width, height)
    }
}