package com.geermank.dots.loading.scale

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import android.view.animation.AccelerateInterpolator
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.view.DotLoadingView

internal class ScaleDotAnimation : DotsAnimation {

    override fun animateDot(container: DotLoadingView, dot: Dot, dotIndex: Int) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0f)

        ObjectAnimator.ofPropertyValuesHolder(dot, scaleX, scaleY).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            startDelay = dotIndex * 150L
            duration = 500L
            interpolator = AccelerateInterpolator()
            start()
        }
    }
}
