package com.geermank.dots.loading

import com.geermank.dots.loading.circular.CircularProgressModifiersFactory

internal interface DotsModifiersFactory {

    companion object {
        val DEFAULT = CircularProgressModifiersFactory()
    }

    fun requiresHorizontalContainer(): Boolean

    fun createDotsAnimation(): DotsAnimation
    fun createDotsPositionDecider(): DotPositionDecider
    fun createDotSpecsOverrider(): DotSpecsOverrider? {
        return null
    }
}
