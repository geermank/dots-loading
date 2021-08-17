package com.geermank.dots.loading.tiktok

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.view.DotLoadingSpecs
import com.geermank.dots.utils.Coordinates

internal class TikTokDotPositionDecider : DotPositionDecider {

    override fun getPosition(
        dotIndex: Int,
        dot: Dot,
        dotLoadingSpecs: DotLoadingSpecs
    ): Coordinates {
        val containerSize = dotLoadingSpecs.containerSize.getSmallest()
        val containerCenter = containerSize / 2.0

        val x = containerCenter + (calculateDotXOffsetMultiplier(dotIndex) * dot.getDiameter().div(2))
        return Coordinates(x, containerCenter)
    }

    private fun calculateDotXOffsetMultiplier(dotIndex: Int): Int {
        // we want the first dot at the left and the second at the right (remember that this
        // animation only works with two dots, not less no more
        return if (dotIndex == 0) {
            -1
        } else {
            1
        }
    }

}