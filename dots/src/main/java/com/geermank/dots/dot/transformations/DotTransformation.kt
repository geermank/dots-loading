package com.geermank.dots.dot.transformations

import android.animation.Animator
import com.geermank.dots.dot.Dot

data class TransformationConfig(
    val duration: Long,
    val repeatCount: Int,
    val repeatMode: Int,
    val listener: Animator.AnimatorListener? = null
) {

    fun shouldRepeat() = repeatCount > 0
}

internal abstract class DotTransformation(protected var config: TransformationConfig) {

    fun updateConfig(config: TransformationConfig) {
        this.config = config
    }

    abstract fun transform(dot: Dot)
}