package com.geermank.dots.loading

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.view.DotLoading
import com.geermank.dots.utils.Coordinates

interface DotsModifiersFactory {
    fun createDotsAnimation(): DotsAnimation
    fun createDotsPositionDecider(): DotPositionDecider
}

internal class NoModifierFactory : DotsModifiersFactory {
    override fun createDotsAnimation(): DotsAnimation {
        return object : DotsAnimation {
            override fun animateDot(container: DotLoading, dot: Dot, dotIndex: Int) {
                // does nothing ja
            }
        }
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return object : DotPositionDecider {
            override fun getPosition(indexOfDot: Int, dot: Dot, containerSize: Int, totalNumberOfDots: Int): Coordinates {
                // just some default value
                return Coordinates(0.0, 0.0)
            }
        }
    }
}
