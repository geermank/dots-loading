package com.geermank.dots.loading.view

import com.geermank.dots.dot.DotSpecs
import com.geermank.dots.dot.color.DotPainter
import com.geermank.dots.dot.color.SingleColorDotPainter
import com.geermank.dots.utils.ViewSize

internal data class DotLoadingSpecs(
    var containerSize: ViewSize = ViewSize(0,0),
    var dotSize: ViewSize = ViewSize(0,0),
    var dotPainter: DotPainter = SingleColorDotPainter(null),
    var numberOfDots: Int = DEFAULT_NUMBER_OF_DOTS
) {

    fun getContainerWidthInPixels(): Int {
        return containerSize.width
    }

    fun getContainerHeightInPixels(): Int {
        return containerSize.height
    }

    fun createDotSpecs(dotIndex: Int) = DotSpecs(dotSize, dotPainter.getColorForDot(dotIndex))
}
