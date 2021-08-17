package com.geermank.dots.loading.view

import androidx.annotation.ColorRes
import com.geermank.dots.dot.DotSpecs
import com.geermank.dots.utils.ViewSize

internal data class DotLoadingSpecs(
    val containerSize: ViewSize,
    val dotSize: ViewSize,
    @ColorRes val dotColor: Int,
    val numberOfDots: Int
) {

    fun getContainerWidthInPixels(): Int {
        return containerSize.width
    }

    fun getContainerHeightInPixels(): Int {
        return containerSize.height
    }

    fun createDotSpecs() = DotSpecs(dotSize, dotColor)
}
