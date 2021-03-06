package com.geermank.dots.loading.bouncing

import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.DotsModifiersFactory
import com.geermank.dots.loading.commons.position.NextToEachOtherCenteredPositionDecider

internal class BouncingModifierFactory : DotsModifiersFactory {

    override fun createDotsAnimation(): DotsAnimation {
        return BouncingDotAnimation()
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return NextToEachOtherCenteredPositionDecider()
    }

    override fun requiresHorizontalContainer(): Boolean {
        return false
    }
}