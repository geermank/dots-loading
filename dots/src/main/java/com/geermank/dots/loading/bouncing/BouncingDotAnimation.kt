package com.geermank.dots.loading.bouncing

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.view.DotLoadingView

internal class BouncingDotAnimation : DotsAnimation {

    override fun animateDot(container: DotLoadingView, dot: Dot, dotIndex: Int) {
        // we start jumping from the middle of the container
        val originY = (container.getSizeInPixels().height / 2f) - (dot.getDiameter() / 2)
        // we jump 2 times the height of a dot
        val targetY = originY - (dot.getDiameter() * 2)
        ObjectAnimator.ofFloat(dot, View.TRANSLATION_Y, originY, targetY).apply {
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = Animation.INFINITE
            startDelay = 100L * dotIndex // the dots at the left start jumping first
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }
    }
}
