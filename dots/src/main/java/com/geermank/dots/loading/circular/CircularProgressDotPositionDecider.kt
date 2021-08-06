package com.geermank.dots.loading.circular

import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.utils.Coordinates
import kotlin.math.cos
import kotlin.math.sin

internal class CircularProgressDotPositionDecider : DotPositionDecider {

    override fun getPosition(indexOfDot: Int, dot: Dot, containerSize: Int, totalNumberOfDots: Int): Coordinates {
        // basically, the container size represents the diameter of the circular progress
        val radius = containerSize / 2
        val angle = calculateAngleBasedOnIndex(indexOfDot)
        val x = calculateXCoordinate(radius, angle)
        val y = calculateYCoordinate(radius, angle)
        return Coordinates(x, y)
    }

    private fun calculateAngleBasedOnIndex(indexOfDot: Int): Double {
        // the index of the dot represents which one of them goes first
        // the rule here is, the first dot initial position has an angle of 90 degrees
        // while the rest of them has an wider initial angle
        return Math.toRadians(90.0) + (indexOfDot * Math.toRadians(10.0))
    }

    private fun calculateXCoordinate(radius: Int, angle: Double): Double {
        return radius * cos(angle)
    }

    private fun calculateYCoordinate(radius: Int, angle: Double): Double {
        return radius * sin(angle)
    }
}
