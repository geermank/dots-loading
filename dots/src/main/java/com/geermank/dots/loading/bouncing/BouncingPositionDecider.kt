package com.geermank.dots.loading.bouncing

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.utils.Coordinates

class BouncingPositionDecider : DotPositionDecider {

    override fun getPosition(indexOfDot: Int, dot: Dot, containerSize: Int, totalNumberOfDots: Int): Coordinates {
        val middleIndex = (totalNumberOfDots / 2) - getIndexOffset(totalNumberOfDots)
        val indexRelativeToTheCenter = indexOfDot - middleIndex

        val y = containerSize / 2.0
        val x = containerSize / 2.0 + indexRelativeToTheCenter * (dot.getDiameter() + 16.0) - getXOffset(totalNumberOfDots, dot)
        return Coordinates(x, y)
    }

    private fun getIndexOffset(totalNumberOfDots: Int): Int {
        // we only apply a corrective offset on even numbers
        return if (totalNumberOfDots % 2 == 0) {
            1
        } else {
            0
        }
    }

    private fun getXOffset(totalNumberOfDots: Int, dot: Dot): Double {
        val dotSize = dot.getDiameter().toDouble()
        return if (totalNumberOfDots % 2 == 0) {
            dotSize
        } else {
            dotSize / 2
        }
    }
}
