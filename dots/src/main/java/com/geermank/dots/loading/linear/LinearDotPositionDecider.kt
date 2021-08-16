package com.geermank.dots.loading.linear

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.view.DotLoadingSpecs
import com.geermank.dots.utils.Coordinates

internal class LinearDotPositionDecider : DotPositionDecider {


    override fun getPosition(dotIndex: Int, dot: Dot, dotLoadingSpecs: DotLoadingSpecs): Coordinates {
        return Coordinates(0.0, (dotLoadingSpecs.getContainerHeightInPixels() / 2.0) - (dot.getDiameter() / 2.0))
    }
}
