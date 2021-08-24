package com.geermank.dots.loading.flip

import com.geermank.dots.loading.DotPositionDecider
import com.geermank.dots.loading.DotsAnimation
import com.geermank.dots.loading.DotsModifiersFactory
import com.geermank.dots.loading.commons.position.NextToEachOtherCenteredPositionDecider

internal class FlipModifierFactory : DotsModifiersFactory {

    override fun requiresHorizontalContainer(): Boolean {
        return true
    }

    override fun createDotsAnimation(): DotsAnimation {
        return FlipDotAnimation()
    }

    override fun createDotsPositionDecider(): DotPositionDecider {
        return NextToEachOtherCenteredPositionDecider()
    }
}
