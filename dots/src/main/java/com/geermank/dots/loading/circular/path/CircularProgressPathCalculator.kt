package com.geermank.dots.loading.circular.path

import android.graphics.RectF
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.view.DotLoadingView

internal interface CircularProgressPathCalculator {
    fun calculateAngleOffset(dotIndex: Int): Int
    fun createRectFForCirclePath(container: DotLoadingView, dot: Dot): RectF
    fun progressSpeed(): Long
    fun progressMovementDirection(): CircularProgressMovementDirection
}