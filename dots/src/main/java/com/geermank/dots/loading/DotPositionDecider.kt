package com.geermank.dots.loading

import com.geermank.dots.dot.Dot
import com.geermank.dots.utils.Coordinates

internal interface DotPositionDecider {
    fun getPosition(indexOfDot: Int, dot: Dot, containerSize: Int, totalNumberOfDots: Int): Coordinates
}