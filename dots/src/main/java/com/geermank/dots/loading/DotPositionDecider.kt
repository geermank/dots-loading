package com.geermank.dots.loading

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.view.DotLoadingSpecs
import com.geermank.dots.utils.Coordinates

internal interface DotPositionDecider {
    fun getPosition(dotIndex: Int, dot: Dot, dotLoadingSpecs: DotLoadingSpecs): Coordinates
}