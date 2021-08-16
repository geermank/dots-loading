package com.geermank.dots.loading.circular.path

import android.graphics.RectF
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.view.DotLoading

const val DEFAULT_DOT_SEPARATION_ANGLE = 15
const val DEFAULT_ANIMATION_SPEED = 2500L

internal class DefaultCircularProgressPathCalculator : CircularProgressPathCalculator {

    override fun calculateAngleOffset(dotIndex: Int): Int {
        return dotIndex * DEFAULT_DOT_SEPARATION_ANGLE
    }

    override fun createRectFForCirclePath(container: DotLoading, dot: Dot): RectF {
        // we must get the smallest value, if not a dot may be cut during animation
        val containerSize = container.getSizeInPixels().getSmallest().toFloat()
        val sizeWithMargin = containerSize - dot.getDiameter()
        return RectF(0f, 0f, sizeWithMargin, sizeWithMargin)
    }

    override fun progressSpeed(): Long {
        return DEFAULT_ANIMATION_SPEED
    }

    override fun progressMovementDirection(): CircularProgressMovementDirection {
        return ClockwiseDirection()
    }
}