package com.geermank.dots.loading.view

import com.geermank.dots.utils.ViewSize

internal data class DotLoadingSpecs(
    val containerSize: ViewSize,
    val dotSize: ViewSize,
    val numberOfDots: Int
) {

    fun getContainerWidthInPixels(): Int {
        return containerSize.width
    }

    fun getContainerHeightInPixels(): Int {
        return containerSize.height
    }

    fun getDotSize(): Int {
        // are always equals anyway
        return dotSize.getSmallest()
    }
}
