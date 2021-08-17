package com.geermank.dots.loading.tiktok

import android.animation.*
import com.geermank.dots.dot.Dot
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.view.DotLoading

private const val FOREGROUND_DOT_ELEVATION = 4f

internal class TikTokDotAnimation : DotsAnimation {

    private val sumOperation: (Double, Double) -> Double = { center, translation ->
        center + translation
    }
    private val subtractOperation: (Double, Double) -> Double = { center, translation ->
        center - translation
    }

    override fun animateDot(container: DotLoading, dot: Dot, dotIndex: Int) {
        // remember that this animation only works with two dots, not less no more
        if (dotIndex == 0) {
            runTranslationAnimation(container, dot, subtractOperation, sumOperation, false)
        } else if (dotIndex == 1) {
            runTranslationAnimation(container, dot, sumOperation, subtractOperation, true)
        }
    }

    private fun runTranslationAnimation(
        container: DotLoading,
        dot: Dot,
        originXOperation: (Double, Double) -> Double,
        targetXOperation: (Double, Double) -> Double,
        startsOnFront: Boolean
    ) {
        val center = getTheCenterOfTheContainer(container)
        val translationAmount = dot.getDiameter().div(2.0)

        val originX = originXOperation(center, translationAmount)
        val targetX = targetXOperation(center, translationAmount)

        val startZ = if (startsOnFront) {
            100f
        } else {
            0f
        }

        val endZ = if (startsOnFront) {
            0f
        } else {
            100f
        }

        runAnimation(dot, originX.toFloat(), targetX.toFloat(), startZ, endZ)
    }

    private fun runAnimation(dot: Dot, startPositionX: Float, endPositionX: Float, startPositionZ: Float, endPositionZ: Float) {
        ValueAnimator.ofFloat(startPositionX , endPositionX).apply {
            addUpdateListener { animation ->
                val currentValue = animation.animatedValue as Float
                dot.translationX = currentValue
            }
            duration = 500
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }

        /*val anim2 = ValueAnimator.ofFloat(startPositionZ , endPositionZ).apply {
            addUpdateListener { animation ->
                val currentValue = animation.animatedValue as Float
                dot.translationZ = currentValue
            }
            duration = 250
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }*/

        /*val anim2 = ObjectAnimator.ofFloat(dot, View.TRANSLATION_Z, startPositionZ, endPositionZ)
        anim2.duration = 500
        anim2.repeatMode = ObjectAnimator.REVERSE
        anim2.repeatCount = ObjectAnimator.INFINITE*/

        /*val set = AnimatorSet()
        set.playTogether(anim1, anim2)
        set.start()*/
    }

    private fun getTheCenterOfTheContainer(container: DotLoading) =
        container.getSizeInPixels().getSmallest() / 2.0
}
