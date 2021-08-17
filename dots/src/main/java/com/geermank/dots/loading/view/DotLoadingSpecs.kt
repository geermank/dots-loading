package com.geermank.dots.loading.view

import androidx.annotation.ColorRes
import com.geermank.dots.dot.DotSpecs
import com.geermank.dots.utils.ViewSize

internal data class DotLoadingSpecs(
    var containerSize: ViewSize = ViewSize(0,0),
    var dotSize: ViewSize = ViewSize(0,0),
    @ColorRes var dotColor: Int = -1,
    var numberOfDots: Int = DEFAULT_NUMBER_OF_DOTS
) {

    fun getContainerWidthInPixels(): Int {
        return containerSize.width
    }

    fun getContainerHeightInPixels(): Int {
        return containerSize.height
    }

    fun createDotSpecs() = DotSpecs(dotSize, dotColor)
}
