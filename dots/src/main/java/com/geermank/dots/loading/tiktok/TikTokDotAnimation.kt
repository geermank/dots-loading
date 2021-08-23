package com.geermank.dots.loading.tiktok

import android.animation.*
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.view.DotLoadingView

private const val BACKGROUND_DOT_Z_AXIS = 0f
private const val FOREGROUND_DOT_Z_AXIS = 100f

/**
 * This animation is thought to be run with two and only two dots. That's why we will
 * always talk about index 0 to refer to the first dot (the one that stars in the background)
 * and index 1 to refer to the second dot (the one that stars in the foreground)
 */
internal class TikTokDotAnimation : DotsAnimation {

    private val calculateRightXFromCenter: (Double, Double) -> Double = { center, translation ->
        center + translation
    }
    private val calculateLeftXFromCenter: (Double, Double) -> Double = { center, translation ->
        center - translation
    }

    override fun animateDot(container: DotLoadingView, dot: Dot, dotIndex: Int) {
        // remember that this animation only works with two dots, not less no more
        if (dotIndex == 0) {
            runTranslationAnimation(container, dot, calculateLeftXFromCenter, calculateRightXFromCenter)
        } else if (dotIndex == 1) {
            modifyZAxis(dot, FOREGROUND_DOT_Z_AXIS)
            runTranslationAnimation(container, dot, calculateRightXFromCenter, calculateLeftXFromCenter)
        }
    }

    private fun runTranslationAnimation(
        container: DotLoadingView,
        dot: Dot,
        originXOperation: (Double, Double) -> Double,
        targetXOperation: (Double, Double) -> Double
    ) {
        val center = getTheCenterOfTheContainer(container)
        val translationAmount = dot.getDiameter().div(2.0)

        val originX = originXOperation(center, translationAmount)
        val targetX = targetXOperation(center, translationAmount)

        runAnimation(dot, originX.toFloat(), targetX.toFloat())
    }

    private fun runAnimation(dot: Dot, startPositionX: Float, endPositionX: Float) {
        ValueAnimator.ofFloat(startPositionX , endPositionX).apply {
            addUpdateListener { animation ->
                val currentValue = animation.animatedValue as Float
                dot.translationX = currentValue
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationRepeat(animation: Animator) {
                    invertZAxisValue(dot)
                }
            })
            duration = 500
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }

    private fun getTheCenterOfTheContainer(container: DotLoadingView) =
        container.getSizeInPixels().getSmallest() / 2.0

    private fun invertZAxisValue(dot: Dot) {
        if (dot.z == BACKGROUND_DOT_Z_AXIS) {
            modifyZAxis(dot, FOREGROUND_DOT_Z_AXIS)
        } else {
            modifyZAxis(dot, BACKGROUND_DOT_Z_AXIS)
        }
    }

    private fun modifyZAxis(dot: Dot, targetZ: Float) {
        dot.z = targetZ
        dot.translationZ = targetZ
    }
}
