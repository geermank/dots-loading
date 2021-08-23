package com.geermank.dots.loading.orbit

import android.graphics.RectF
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.circular.path.CircularProgressMovementDirection
import com.geermank.dots.loading.circular.path.CircularProgressPathCalculator
import com.geermank.dots.loading.circular.path.ClockwiseDirection
import com.geermank.dots.loading.circular.path.CounterClockwiseDirection
import com.geermank.dots.loading.view.DotLoadingView

private const val RANDOM_INFERIOR_ANGLE_LIMIT = 15
private const val RANDOM_SUPERIOR_ANGLE_LIMIT = 135
private const val RANDOM_INFERIOR_SPEED_LIMIT = 2000L
private const val RANDOM_SUPERIOR_SPEED_LIMIT = 5000L

internal class OrbitPathCalculator : CircularProgressPathCalculator {

    override fun calculateAngleOffset(dotIndex: Int): Int {
        return (RANDOM_INFERIOR_ANGLE_LIMIT..RANDOM_SUPERIOR_ANGLE_LIMIT).random()
    }

    override fun createRectFForCirclePath(container: DotLoadingView, dot: Dot): RectF {
        val containerSize = container.getSizeInPixels().getSmallest()

        val maxValue = containerSize - dot.getDiameter()
        val minValue = dot.getDiameter() * 2

        val rectSize = (minValue..maxValue).random().toFloat()

        val superiorVertex = calculateSuperiorVertex(maxValue, rectSize)
        val inferiorVertex = calculateInferiorVertex(superiorVertex, rectSize)

        return RectF(superiorVertex, superiorVertex, inferiorVertex, inferiorVertex)
    }

    private fun calculateSuperiorVertex(parentMaxSize: Int, rectMaxValue: Float): Float {
        return (parentMaxSize / 2) - (rectMaxValue / 2)
    }

    private fun calculateInferiorVertex(
        superiorVertex: Float,
        rectSize: Float
    ) = superiorVertex + rectSize

    override fun progressSpeed(): Long {
        return (RANDOM_INFERIOR_SPEED_LIMIT..RANDOM_SUPERIOR_SPEED_LIMIT).random()
    }

    override fun progressMovementDirection(): CircularProgressMovementDirection {
        val directions = arrayOf(ClockwiseDirection(), CounterClockwiseDirection())
        val randomIndex = (0..directions.lastIndex).random()
        return directions[randomIndex]
    }
}
