package com.geermank.dots.loading.linear

import android.animation.ValueAnimator
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.view.DotLoadingView

private const val MARGIN_BETWEEN_DOTS_FACTOR = 1.5f

internal class LinearDotsAnimation : DotsAnimation {

    override fun animateDot(container: DotLoadingView, dot: Dot, dotIndex: Int) {
        val startPositionX = 0f + (dotIndex * dot.getDiameter() * MARGIN_BETWEEN_DOTS_FACTOR)
        val endPositionX = calculateEndX(container, dot, dotIndex)

        ValueAnimator.ofFloat(startPositionX , endPositionX).apply {
            addUpdateListener { animation ->
                val currentValue = animation.animatedValue as Float
                dot.translationX = currentValue
            }
            duration = 1000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }

    private fun calculateEndX(container: DotLoadingView, dot: Dot, dotIndex: Int): Float {
        return container.getSizeInPixels().width -
                (dot.getDiameter() * ((container.childCount) - dotIndex) * MARGIN_BETWEEN_DOTS_FACTOR)
    }
}
