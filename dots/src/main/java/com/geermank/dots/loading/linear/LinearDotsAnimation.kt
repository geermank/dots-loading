package com.geermank.dots.loading.linear

import android.animation.ValueAnimator
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.view.DotLoading

internal class LinearDotsAnimation : DotsAnimation {

    override fun animateDot(container: DotLoading, dot: Dot, dotIndex: Int) {
        val startPositionX = 0f + dotIndex * dot.getDiameter()
        val endPositionX = container.getSizeInPixels().width - (startPositionX + dot.getDiameter())

        ValueAnimator.ofFloat(startPositionX , endPositionX).apply {
            addUpdateListener { animation ->
                val currentValue = animation.animatedValue as Float
                dot.translationX = currentValue
            }
            duration = 1000L
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }
}
