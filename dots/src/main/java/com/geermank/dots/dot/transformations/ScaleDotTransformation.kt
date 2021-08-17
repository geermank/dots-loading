package com.geermank.dots.dot.transformations

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import com.geermank.dots.dot.Dot

internal class ScaleDotTransformation(
    private val scaleFactor: Float,
    config: TransformationConfig
) : DotTransformation(config) {

    override fun transform(dot: Dot) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, scaleFactor)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, scaleFactor)

        ObjectAnimator.ofPropertyValuesHolder(dot, scaleX, scaleY).apply {
            duration = config.duration
            if (config.shouldRepeat()) {
                repeatCount = config.repeatCount
                repeatMode = config.repeatMode
            }
            config.listener?.let { addListener(it) }
            start()
        }
    }
}
