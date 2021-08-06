package com.geermank.dots.loading.circular

import android.animation.ValueAnimator
import android.graphics.Path
import android.graphics.PathMeasure
import android.view.animation.LinearInterpolator
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.circular.path.CircularProgressPathCalculator
import com.geermank.dots.loading.circular.path.DefaultCircularProgressPathCalculator
import com.geermank.dots.loading.view.DotLoading

private const val ARC_START_ANGLE = 0f
private const val ARC_SWEEP_ANGLE = 180f

internal class CircularProgressAnimation(
    private val pathCalculator: CircularProgressPathCalculator = DefaultCircularProgressPathCalculator()
) : DotsAnimation {

    override fun animateDot(container: DotLoading, dot: Dot, dotIndex: Int) {
        val pathMeasure = PathMeasure(
            createCirclePath(container, dot, dotIndex),
            false
        )
        val position = FloatArray(2)
        ValueAnimator.ofFloat(0f, pathMeasure.length).apply {
            addUpdateListener { animation ->
                val currentValue = animation.animatedValue as Float
                pathMeasure.getPosTan(currentValue, position, null)
                dot.translationX = position[0]
                dot.translationY = position[1]
            }
            duration = pathCalculator.progressSpeed()
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            start()
        }
    }

    private fun createCirclePath(container: DotLoading, dot: Dot, dotIndex: Int): Path {
        val angleOffset = pathCalculator.calculateAngleOffset(dotIndex)
        val circleRect = pathCalculator.createRectFForCirclePath(container, dot)
        val movementDirection = pathCalculator.progressMovementDirection()
        return Path().apply {
            arcTo(circleRect, ARC_START_ANGLE - angleOffset, movementDirection.applyOnAngle(ARC_SWEEP_ANGLE))
            arcTo(circleRect, ARC_SWEEP_ANGLE - angleOffset, movementDirection.applyOnAngle(ARC_SWEEP_ANGLE))
        }
    }
}
