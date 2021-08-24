package com.geermank.dots.loading.flip

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.util.Property
import android.view.View
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.view.DotLoadingView

internal class FlipDotAnimation : DotsAnimation {

    override fun animateDot(container: DotLoadingView, dot: Dot, dotIndex: Int) {
        flipHorizontal(dot)
    }

    private fun flipHorizontal(dot: Dot) {
        flip(dot, View.ROTATION_X) { flipVertical(dot) }
    }

    private fun flipVertical(dot: Dot) {
        flip(dot, View.ROTATION_Y) { flipHorizontal(dot) }
    }

    private fun flip(view: Dot, property: Property<View, Float>, onAnimationEnd: (Dot) -> Unit) {
        ObjectAnimator.ofFloat(view, property, -180f, 0f).apply {
            duration = 500
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    onAnimationEnd(view)
                }
            })
            start()
        }
    }
}
