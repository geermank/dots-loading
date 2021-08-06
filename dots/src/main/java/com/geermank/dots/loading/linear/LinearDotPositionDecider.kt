package com.geermank.dots.loading.linear

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.utils.Coordinates

class LinearDotPositionDecider : DotPositionDecider {

    override fun getPosition(indexOfDot: Int, dot: Dot, containerSize: Int, totalNumberOfDots: Int): Coordinates {
        return Coordinates(0.0, (containerSize / 2.0) - (dot.getDiameter() / 2.0))
    }
}
