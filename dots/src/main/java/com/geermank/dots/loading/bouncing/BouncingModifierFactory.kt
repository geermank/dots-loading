package com.geermank.dots.loading.bouncing

import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.DotSpecsOverrider
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.DotsModifiersFactory

internal class BouncingModifierFactory : DotsModifiersFactory {

    override fun createDotsAnimation(): DotsAnimation {
        return BouncingDotAnimation()
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return BouncingPositionDecider()
    }

    override fun requiresHorizontalContainer(): Boolean {
        return false
    }
}