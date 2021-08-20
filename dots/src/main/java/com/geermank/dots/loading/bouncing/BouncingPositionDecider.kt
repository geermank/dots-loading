package com.geermank.dots.loading.bouncing

import com.geermank.dots.dot.Dot
import com.geermank.dots.extensions.isEven
import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.view.DotLoadingSpecs
import com.geermank.dots.utils.Coordinates

internal class BouncingPositionDecider : DotPositionDecider {

    override fun getPosition(dotIndex: Int, dot: Dot, dotLoadingSpecs: DotLoadingSpecs): Coordinates {
        val y = calculateYCoordinate(dotLoadingSpecs)
        val x = calculateXCoordinate(dotIndex, dot, dotLoadingSpecs)
        return Coordinates(x, y)
    }

    private fun calculateYCoordinate(dotLoadingSpecs: DotLoadingSpecs): Double {
        return dotLoadingSpecs.getContainerHeightInPixels() / 2.0
    }

    private fun calculateXCoordinate(
        dotIndex: Int,
        dot: Dot,
        dotLoadingSpecs: DotLoadingSpecs
    ): Double {
        val middleIndex = (dotLoadingSpecs.numberOfDots / 2) - getIndexOffset(dotLoadingSpecs.numberOfDots)
        val indexRelativeToTheCenter = dotIndex - middleIndex
        return dotLoadingSpecs.getContainerWidthInPixels() / 2.0 +
                indexRelativeToTheCenter * (dot.getDiameter() + 16.0) - // add some margin between the dots
                getXOffset(dotLoadingSpecs.numberOfDots, dot)
    }

    private fun getIndexOffset(totalNumberOfDots: Int): Int {
        // we only apply a corrective offset on even numbers
        return if (totalNumberOfDots.isEven()) {
            1
        } else {
            0
        }
    }

    private fun getXOffset(totalNumberOfDots: Int, dot: Dot): Double {
        // we only apply a corrective offset on even numbers
        val dotSize = dot.getDiameter().toDouble()
        return if (totalNumberOfDots.isEven()) {
            dotSize
        } else {
            dotSize / 2
        }
    }
}
